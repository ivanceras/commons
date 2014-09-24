package com.ivanceras.commons.types;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.ivanceras.commons.crypto.Crypto;
import com.ivanceras.commons.strings.CStringUtils;

public class TestFieldTypes {


	@Test
	public void test1(){
		boolean ret = FieldTypes.isSimple(String.class);
		assertTrue(ret);

		ret = FieldTypes.isSimple(Date.class);
		assertTrue(ret);

		ret = FieldTypes.isSimple(CStringUtils.class);
		assertFalse(ret);

		ret = FieldTypes.isSimple(int.class);
		assertTrue(ret);

		ret = FieldTypes.isSimple(byte.class);
		assertTrue(ret);

		ret = FieldTypes.isSimple(char.class);
		assertTrue(ret);

		ret = FieldTypes.isSimple(Void.class);
		assertTrue(ret);


		ret = FieldTypes.isSimple(BigDecimal.class);
		assertTrue(ret);

		ret = FieldTypes.isSimple(Crypto.class);
		assertFalse(ret);

	}

}
