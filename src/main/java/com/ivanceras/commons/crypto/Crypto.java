package com.ivanceras.commons.crypto;

import java.security.SignatureException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


/**
 * 
 * Provides methods for signing API request, same as AWS is using.
 * 
 */
public class Crypto {

	public static final String HMAC_MD5_ALGORITHM = "HmacMD5";
	public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	public static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
	public static final String HMAC_SHA512_ALGORITHM = "HmacSHA512";


	public static String calculate(String algorithm, String data, String key) throws SignatureException{
		byte[] rawBytes = calculateRaw(algorithm, data, key);
		return CBase64Utils.toBase64NoPadding(rawBytes);
	}

	public static byte[] calculateRaw(String algorithm, String data, String key) throws SignatureException{
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), algorithm);
			Mac mac = Mac.getInstance(algorithm);
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(data.getBytes());
			return rawHmac;
		} catch (Exception e) {
			throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
		}
	}

	public static String calculateHmacMD5(String data, String key) throws SignatureException{
		return calculate(HMAC_MD5_ALGORITHM, data, key);
	}

	public static String calculateHmacSHA512(String data, String key) throws SignatureException{
		return calculate(HMAC_SHA512_ALGORITHM, data, key);
	}
	public static String calculateHmacSHA256(String data, String key) throws SignatureException{
		return calculate(HMAC_SHA256_ALGORITHM, data, key);
	}

	public static String calculateHmacSHA1(String data, String key)throws java.security.SignatureException{
		return calculate(HMAC_SHA1_ALGORITHM, data, key);
	}

	/**
	 * create a signature of the data using HmacSHA1 algorithm
	 * @param data
	 * @param key
	 * @return
	 * @throws SignatureException
	 */
	public static String sign(String data, String key) throws SignatureException{
		return calculateHmacSHA1(data, key);
	}



}