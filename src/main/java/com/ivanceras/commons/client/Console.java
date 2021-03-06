package com.ivanceras.commons.client;

import com.google.gwt.core.shared.GWT;

public class Console {
	
	/**
	 * Won't print log console when deployed in production
	 */
	static boolean production = false;
	
	private static boolean can(){
		if(GWT.isClient() && !production){
			return true;
		}
		else{
			return false;
		}
	}

	public static void debug(String msg){
		debug(msg, "");
	}
	public static void debug(String msg, Object js){
		if(can()){
			nativeDebug(msg, js);
		}else{
			System.out.println(msg+" "+js);
		}
	}

	public static void error(String msg){
		error(msg, "");
	}

	public static void error(String msg, Object obj){
		if(can()){
			nativeError(msg, obj);
		}else{
			System.out.println(msg);
		}
	}
	
	public static void group(String msg){
		nativeGroup(msg, "");
	}
	
	public static void group(String msg, Object obj){
		if(can()){
			nativeGroup(msg, obj);
		}else{
			System.out.println(msg);
		}
	}
	public static void groupCollapsed(String msg){
		groupCollapsed(msg, "");
	}

	public static void groupCollapsed(String msg, Object obj){
		if(can()){
			nativeGroupCollapsed(msg, obj);
		}else{
			System.out.println(msg);
		}
	}
	
	public static void groupEnd(){
		if(can()){
			nativeGroupEnd();
		}
	}
	
	public static void info(String msg){
		info(msg, "");
	}

	
	public static void info(String msg, Object obj){
		if(can()){
			nativeInfo(msg, obj);
		}else{
			System.out.println(msg);
		}
	}
	
	public static void log(String msg){
		log(msg, "");
	}
	
	public static void log(String msg, Object js){
		if(can()){
			nativeLog(msg, js);
		}else{
			System.out.println(msg+" "+js);
		}
	}

	public static native void nativeDebug(String msg, Object obj)/*-{
		console.debug(msg+" "+JSON.stringify(obj));
	}-*/;

	public static native void nativeError(String msg, Object obj)/*-{
		console.error(msg+" "+JSON.stringify(obj));
	}-*/;

	public static native void nativeGroup(String msg, Object obj)/*-{
		console.group(msg, obj);
	}-*/;

	public static native void nativeGroupCollapsed(String msg, Object obj)/*-{
		console.groupCollapsed(msg, obj);
	}-*/;

	public static native void nativeGroupEnd()/*-{
		console.groupEnd();
	}-*/;
	
	public static native void nativeInfo(String msg, Object obj)/*-{
		console.info(msg, obj);
	}-*/;

	public static native void nativeLog(String msg)/*-{
		console.log(msg);
	}-*/;

	public static native void nativeLog(String msg, Object obj)/*-{
		console.log(msg, obj);
	}-*/;
}
