package com.ivanceras.commons.crypto;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class Base64UUID {

	public static String toBase64(UUID uuid) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());
		return Base64.encodeBase64String(bb.array());
	}
	public static UUID toUUID(String base64) {
		byte[] bytes = Base64.decodeBase64(base64);
		ByteBuffer bb = ByteBuffer.wrap(bytes);
		UUID uuid = new UUID(bb.getLong(), bb.getLong());
		return uuid;
	}
	

}
