package com.ivanceras.commons.crypto;

import static org.junit.Assert.*;

import java.security.SignatureException;

import org.junit.Test;

public class TestCrypto {

	@Test
	public void testCalcSha1Hash() throws SignatureException {
		String data = "The quick brown fox jumps over the lazy dog";
		String key =  "lee";
	    String result = Crypto.calculateHmacSHA1(data, key);
	    System.out.println("sha1: "+result);
	    assertEquals(result, "23UU3hh+mB/RyvZzCsdc1DcjI2I=");

	}
	
	
	@Test
	public void testCalculateHmacSHA512() throws SignatureException {
		String data = "The quick brown fox jumps over the lazy dog";
		String key =  "lee";
		String result = Crypto.calculateHmacSHA512(data, key);
	    System.out.println("sha512: "+result);
	    assertEquals(result, "Crv7f0MfhR/FkRE8vcjnBgBIJDz6D7VpW/1wCvz1epoxofiwZv+eF87+LGaCp277A7zBWym12iuB4Q2e0ag36g==");

	}
	
	@Test
	public void testCalculateHmacSHA256() throws SignatureException {
		String data = "The quick brown fox jumps over the lazy dog";
		String key =  "lee";
	    String result = Crypto.calculateHmacSHA256(data, key);
	    System.out.println("sha256: "+result);
	    assertEquals(result, "4lJxIKB55ONLcG0PWK7Em3nI+G6tMZ2XXIgqiAxA4pg=");

	}
	
	@Test
	public void testCalculateHmacMD5() throws SignatureException {
		String data = "The quick brown fox jumps over the lazy dog";
		String key =  "lee";
	    String result = Crypto.calculateHmacMD5(data, key);
	    System.out.println("md5: "+result);
	    assertEquals(result, "X6a7QWjggfk+85Gd3esALw==");

	}
}
