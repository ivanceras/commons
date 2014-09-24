package com.ivanceras.commons.crypto;

import java.security.SignatureException;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * Provides methods for signing API request, same as AWS is using.
 * 
 */
public class Crypto {

	private static final String HMAC_MD5_ALGORITHM = "HmacMD5";
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
	private static final String HMAC_SHA512_ALGORITHM = "HmacSHA512";


	public static String calculate(String algorithm, String data, String key) throws SignatureException{
		String result;
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), algorithm);
			Mac mac = Mac.getInstance(algorithm);
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(data.getBytes());
			result = Base64.encodeBase64String(rawHmac);
		} catch (Exception e) {
			throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
		}
		return result;
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

	public static String createRandomKey(){
		UUID uuid = UUID.randomUUID();
		String base64 = Base64UUID.toBase64(uuid);
		return base64;
	}


}