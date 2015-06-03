package com.eleomanni.nercurio.utils;

import java.util.ArrayList;
import java.util.Collection;

public class Utils {

	public static boolean isEmpty(Object o){
		if (o == null) return true;
		
		if (o instanceof String) return ((String)o).isEmpty()&&((String)o).length()<=0;
		
		if (o instanceof ArrayList) return ((ArrayList<?>)o).isEmpty();
		
		if (o instanceof Collection) return ((Collection<?>) o).isEmpty();
		
		return false;
	}
	
	public static boolean isNotEmpty(Object o){
		return !isEmpty(o);
	}
}
