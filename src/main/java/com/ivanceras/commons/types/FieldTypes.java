package com.ivanceras.commons.types;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
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
//			long time = ((Date)obj).getTime();
			String objString = obj.toString();
			Console.debug("obj string: "+objString+" "+clazz+" from "+objString.getClass());
			Long longValue = Long.parseLong(obj.toString());
//			TODO: how to date ?
			return new Date(longValue);
		}
		else{
			return null;
		}
	}
}
