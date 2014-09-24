package com.ivanceras.commons.crypto;

import static org.junit.Assert.*;

import java.security.SignatureException;

import org.junit.Before;
import org.junit.Test;

public class TestCryptoWithRandomKeys {
	
	String data = "The quick brown dragon jumps over the lazy dinosaur with wings but violeta give in willingly";
	String key = null;
	
	@Before
	public void setUp(){
		key = "4Hf7NrdbRGyD8wFVT0zveQ=="; //Crypto.createRandomKey();
		System.out.println("key: "+key);
	}

	@Test
	public void testCalcSha1Hash() throws SignatureException {
	    String result = Crypto.calculateHmacSHA1(data, key);
	    System.out.println("sha1: "+result);
	    assertEquals(result, "3GFme7JR1ZSjIN2WUrmQqiJoR/U=");
	    
	    String signature = Crypto.sign(data, key);
	    assertEquals(result, signature);

	}
	
	
	@Test
	public void testCalculateHmacSHA512() throws SignatureException {
		String result = Crypto.calculateHmacSHA512(data, key);
	    System.out.println("sha512: "+result);
	    assertEquals(result, "Pksr0/ZnEYDun+TeEdhFPg2DZ68hzKVjLEQnTNLewI8IbiMGhju97W/DZVQyzyZe+OQgHSx8wd8in3s5lx2UDw==");

	}
	
	@Test
	public void testCalculateHmacSHA256() throws SignatureException {
	    String result = Crypto.calculateHmacSHA256(data, key);
	    System.out.println("sha256: "+result);
	    assertEquals(result, "ubRqj0Q9KdGNvInC+OKiMGljTDZVQ996YxiPVI044/U=");

	}
	
	@Test
	public void testCalculateHmacMD5() throws SignatureException {
	    String result = Crypto.calculateHmacMD5(data, key);
	    System.out.println("md5: "+result);
	    assertEquals(result, "Z/nr/odYMtoOaRD7VpHbng==");

	}
}
