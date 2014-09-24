package com.ivanceras.commons.crypto;

import static org.junit.Assert.*;

import java.security.SignatureException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

//import com.google.gwt.user.server.Base64Utils;

public class TestBase64 {
	
	String data = "The quick brown fox jumps over the lazy dog-- asdmasd aopasdmask [seoifasdk fjsdkfjs";
	String key =  "lee";
	
	@Test
	public void test1(){
		String cbase64 = CBase64Utils.toBase64(data.getBytes());
		String google = com.google.gwt.user.server.Base64Utils.toBase64(data.getBytes());
		String apache = Base64.encodeBase64String(data.getBytes());

		System.out.println("   gwt: "+cbase64);
		System.out.println("google: "+google);
		System.out.println("apache: "+apache);
		assertEquals(cbase64, apache);
		assertEquals(google, apache);
	}
	
	
	@Test
	public void test2() throws SignatureException{
		byte[] raw = Crypto.calculateRaw(Crypto.HMAC_SHA1_ALGORITHM, data, key);
		String cbase64 = CBase64Utils.toBase64NoPadding(raw);
		String google = com.google.gwt.user.server.Base64Utils.toBase64(raw);
		String apache = Base64.encodeBase64String(raw);
		String apacheUrlSafe = Base64.encodeBase64URLSafeString(raw);
		
		System.out.println("        cbase64: ["+cbase64+"]");
		System.out.println("         google: "+google);
		System.out.println("         apache: "+apache);
		System.out.println("apache url safe: ["+apacheUrlSafe+"]");
		assertEquals(cbase64, apacheUrlSafe);
	}

}
