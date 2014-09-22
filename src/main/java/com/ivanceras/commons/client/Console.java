package com.ivanceras.commons.client;

import com.google.gwt.core.shared.GWT;

public class Console {

	public static void log(String msg, Object js){
		if(GWT.isClient()){
			nativeLog(msg, js);
		}else{
			System.out.println(msg+" "+js);
		}
	}
	public static void debug(String msg, Object js){
		if(GWT.isClient()){
			nativeDebug(msg, js);
		}else{
			System.out.println(msg+" "+js);
		}
	}

	public static void log(String msg){
		if(GWT.isClient()){
			nativeLog(msg);
		}else{
			System.out.println(msg);
		}
	}

	public static native void nativeLog(String msg)/*-{
		console.log(JSON.stringify(msg));
	}-*/;

	public static native void nativeLog(String msg, Object obj)/*-{
		console.log(msg+" "+JSON.stringify(obj));
	}-*/;

	public static native void nativeDebug(String msg, Object obj)/*-{
		console.debug(msg+" "+JSON.stringify(obj));
	}-*/;

}
