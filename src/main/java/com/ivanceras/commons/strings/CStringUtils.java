/*******************************************************************************
 * Copyright by CMIL
 ******************************************************************************/
package com.ivanceras.commons.strings;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Common String utility used by ORM
 * @author lee
 *
 */

public class CStringUtils {

	public static String truncate(String var, int limit){
		if(var.length() > limit){
			String char1 = var.substring(0, limit);
			return char1;
		}
		return var;
	}
	public static String toVariableName(String var){
		return toVariableName(var, false);
	}

	public static String toVariableName(String var, boolean camelCaseUnderScore){
		if(camelCaseUnderScore){
			var = camelCaseUnderscores(var);
		}
		String char1 = var.substring(0, 1);
		String rest = var.substring(1, var.length());
		char1 = char1.toLowerCase();
		return char1+rest;
	}
	public static String capitalize(String var){
		return capitalize(var, false);
	}
	
	public static String capitalize(String var, boolean camelCaseUnderScore){
		if(var == null) return null;
		if(camelCaseUnderScore){
			var = camelCaseUnderscores(var);
		}
		String char1 = var.substring(0, 1);
		String rest = var.substring(1, var.length());
		char1 = char1.toUpperCase();
		return char1+rest;
	}
	public static String getModelNameCamelCase(String tableName){
		return CStringUtils.camelCaseUnderscores(capitalize(tableName.toLowerCase()));
	}

	public static String getModelName(String tableName){
		return capitalize(tableName.toLowerCase());
	}

	public static String removeVowelsExceptFirst(String var){
		if(var == null){
			return null;
		}
		if(var.length() < 1){
			return var;
		}
		String char1 = var.substring(0, 1);
		String rest = var.substring(1, var.length());
		String novowels = rest.replaceAll("[aeiou]", "");
		return char1+novowels;
	}


	public static String getHash(String var){
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] varbytes = var.getBytes("UTF-8");
			byte[] result = md.digest(varbytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < result.length; ++i) {
				sb.append(Integer.toHexString(0xFF & result[i]));
			}
			String hash = sb.toString();
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String beautify(String str){
		if(str == null){
			return null;
		}
		str = str.replace("-", " ");
		str = capitalize(str, true);
		return str;
	}

	public static String underscoreSpaces(String str){
		if(str == null){
			return null;
		}
		str = str.replace(" ", "_");
		return str;
	}

	public static int indexOf(String[] attributes, String attribute){
		if(attributes != null){
			for(int i = 0; i < attributes.length; i++){
				if(attribute.equals(attributes[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
	public static boolean inArray(String[] attributes, String attribute){
		if(indexOf(attributes, attribute)>=0){
			return true;
		}
		return false;
	}
	
	public static String[] mergeString(String[] str1, String[] str2){
		String[] merged = new String[str1.length + str2.length];
		for(int i = 0; i < str1.length; i++){
			merged[i] = str1[i];
		}
		for(int i = 0; i < str2.length; i++){
			merged[i+str1.length] = str2[0];
		}
		return merged;
	}

	public static String beautifyFieldName(String name) {
		if(name == null){
			return null;
		}
		String str = name.replaceFirst("Is", "").replaceFirst("Ad ", "");
		return capitalize(str, true);
	}

	public static String toValidColumn(String str){
		return str.replace("-", "_").replace(" ", "_").toLowerCase();
	}
	
	public static String camelCaseUnderscores(String str){
		StringBuffer buff = new StringBuffer();
		boolean capitalize = false;
		boolean doAppend = false;
		for(int i = 0 ; i < str.length(); i++){
			char ch = str.charAt(i);
			if(capitalize){
				ch = Character.toUpperCase(ch);
				doAppend = true;
			}
			if(ch == '_'){
				capitalize = true;
				doAppend = false;
			}
			else{
				capitalize = false;
				doAppend = true;
			}
			if(doAppend){
				buff.append(ch);
			}
			
		}
		return buff.toString();
	}
}
