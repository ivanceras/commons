package com.ivanceras.commons.types;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.ivanceras.commons.client.Console;

/**
 * Given a class determine whether it is a complex type or simple type
 * 
 * @author lee
 *
 */
public class FieldTypes {
	
	 private static final Set<Class<?>> WRAPPER_TYPES = getWrapperTypes();
	 private static final Set<Class<?>> BASIC_TYPES = getBasicTypes();
	
	/**
	 * If the class is primitive or one of the wrapper types or one of the basic types, then it is a simple class;
	 * @param clazz
	 * @return
	 */
	public static boolean isSimple(Class<?> clazz){
		if(clazz.isPrimitive()){
			return true;
		}
		else if(isWrapperType(clazz)){
			return true;
		}
		else if(isBasicType(clazz)){
			return true;
		}
		else{
			return false;
		}
	}
	
	private static boolean isWrapperType(Class<?> clazz){
        return WRAPPER_TYPES.contains(clazz);
    }
	
	private static boolean isBasicType(Class<?> clazz){
        return BASIC_TYPES.contains(clazz);
    }

	
	private static Set<Class<?>> getWrapperTypes(){
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        return ret;
    }
	
	private static Set<Class<?>> getBasicTypes(){
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Date.class);
        ret.add(String.class);
        ret.add(BigDecimal.class);
        ret.add(UUID.class);
        ret.add(Time.class);
        ret.add(Timestamp.class);
        ret.add(HashMap.class);
        return ret;
    }
	
	
	/**
	 * supply the class
	 * @param clazz
	 * @param obj
	 * @return
	 */
	public static Object getValue(Class<?> clazz, Object obj){
		if(obj == null){return null;}
		if(clazz.equals(String.class)){
			return obj.toString();
		}
		else if(clazz.equals(Boolean.class)){
			if(obj.toString().equals("true")){
				return new Boolean(true);
			}else if(obj.toString().equals("false")){
				return new Boolean(false);
			}
			else{//an unset boolean
				return null;
			}
		}
		else if(clazz.equals(Integer.class)){
			return Integer.parseInt(obj.toString());
		}
		else if(clazz.equals(BigDecimal.class)){
			return new BigDecimal(Double.parseDouble(obj.toString()));
		}
		else if(clazz.equals(UUID.class)){
			return UUID.fromString(obj.toString());
		}
		else if(clazz.equals(Date.class)){
			Long longValue = Long.parseLong(obj.toString());
			return new Date(longValue);
		}
		else if(clazz.equals(Time.class)){
			String timeStr = obj.toString();
			Console.log("So how do we convert: ["+timeStr+"] to "+Time.class);
			return Time.valueOf(timeStr);
		}
		else if(clazz.equals(Timestamp.class)){
			Long longValue = Long.parseLong(obj.toString());
			return new Timestamp(longValue);
		}
		else if(clazz.equals(HashMap.class)){
			Console.log("What to do with hashmap in javascript?");
			return obj.toString();
		}
		else{
			Console.error("No implementation of converting "+obj+" to "+clazz+" returning this as null, or will create a ClassCastException");
			return null;
		}
	}
}
