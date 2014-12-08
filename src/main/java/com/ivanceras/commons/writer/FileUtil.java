package com.ivanceras.commons.writer;

import java.io.*;

public class FileUtil {

	public static void writeToFile(String sb, String directory, String fileName){
		File dir = new File (directory);
		dir.mkdirs();//create necessary directory
		if(!directory.endsWith("/")){
			directory = directory +"/";
		}
		File out = new File (directory+fileName);
		System.out.println(directory+fileName);
		try {
			Writer fw = new OutputStreamWriter(new FileOutputStream(out, false), "UTF-8");
			try {
				fw.write(sb);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToFile(StringBuffer sb, String directory, String fileName){
		writeToFile(sb.toString(), directory, fileName);
	}
	
	public static void appendToFile(String sb,String directory, String fileName){
		if(!directory.endsWith("/")){
			directory = directory +"/";
		}
		File out = new File (directory+fileName);
		try {
			Writer fw = new OutputStreamWriter(new FileOutputStream(out, true), "UTF-8");
			try {
				fw.write(sb.toString());
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static String readFile(String filename){
		File in = new File(filename);
		try {
			Reader fr = new InputStreamReader(new FileInputStream(in),"UTF-8");
			char[] cbuf = new char[(int) in.length()];
			try{
				fr.read(cbuf);
				String ret = String.valueOf(cbuf);
				fr.close();
				return ret;
			}catch(Exception e){
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
