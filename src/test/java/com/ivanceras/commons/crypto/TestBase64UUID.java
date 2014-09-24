package com.ivanceras.commons.crypto;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.ivanceras.commons.server.Base64UUID;

public class TestBase64UUID {
	
	@Test
	public void test1(){
		UUID uuid = UUID.randomUUID();
		System.out.println("uuid: "+uuid);
		String ret = Base64UUID.toBase64(uuid);
		System.out.println("base64: "+ret);
		
		UUID uuid_back = Base64UUID.toUUID(ret);
		System.out.println("back to uuid: "+uuid_back);
		String ret_back = Base64UUID.toBase64(uuid_back);
		System.out.println("back to base64: "+ret_back);
		assertEquals(uuid, uuid_back);
		assertEquals(ret, ret_back);
	}

}
