package com.ivanceras.commons.crypto;

import static org.junit.Assert.*;

import java.security.SignatureException;

import org.junit.Test;

public class TestCrypto {

	String data = "The quick brown fox jumps over the lazy dog";
	String key =  "lee";
	
	@Test
	public void testSign() throws SignatureException{
		String data1 = "true | Thu Sep 25 01:09:24 GMT+800 2014 | 8cdb0f3e-39ad-4277-81ab-324d4aef869f | The Series of Apple Iphones | Iphone9s | 900.23000000000001819 | a4159ce9-85e6-418e-b018-82054e79d550 | Thu Sep 25 01:09:24 GMT+800 2014 | 8cdb0f3e-39ad-4277-81ab-324d4aef869f";
		String key1 = "secret";
		String signature = Crypto.sign(data1, key1);
		String expected = "hBRUwuYwLGCA7pwNqsFKs0NxM7Q";
		System.out.println("signing "+data1);
		System.out.println("Using key: "+key1);
		System.out.println(" signature: "+signature);
		System.out.println("  expected: "+expected);
		assertEquals(signature, expected);
	}

	
	@Test
	public void testCalcSha1Hash() throws SignatureException {
	    String result = Crypto.calculateHmacSHA1(data, key);
	    System.out.println("sha1: "+result);
	    assertEquals(result, "23UU3hh$mB_RyvZzCsdc1DcjI2I");

	}
	
	
	@Test
	public void testCalculateHmacSHA512() throws SignatureException {
		String result = Crypto.calculateHmacSHA512(data, key);
	    System.out.println("sha512: "+result);
	    assertEquals(result, "Crv7f0MfhR_FkRE8vcjnBgBIJDz6D7VpW_1wCvz1epoxofiwZv$eF87$LGaCp277A7zBWym12iuB4Q2e0ag36g");

	}
	
	@Test
	public void testCalculateHmacSHA256() throws SignatureException {
	    String result = Crypto.calculateHmacSHA256(data, key);
	    System.out.println("sha256: "+result);
	    assertEquals(result, "4lJxIKB55ONLcG0PWK7Em3nI$G6tMZ2XXIgqiAxA4pg");

	}
	
	@Test
	public void testCalculateHmacMD5() throws SignatureException {
	    String result = Crypto.calculateHmacMD5(data, key);
	    System.out.println("md5: "+result);
	    assertEquals(result, "X6a7QWjggfk$85Gd3esALw");

	}
}
