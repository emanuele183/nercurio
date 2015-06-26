package com.eleomanni.nercurio.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.osgi.service.prefs.Preferences;

public class Utils {

	public static boolean isEmpty(Object o){
		if (o == null) return true;
		
		if (o instanceof String) return ((String)o).isEmpty()&&((String)o).length()<=0;
		
		if (o instanceof ArrayList) return ((ArrayList<?>)o).isEmpty();
		
		if (o instanceof Collection) return ((Collection<?>) o).isEmpty();
		
		if (o instanceof Connection){
			try {
				return ((Connection)o).isClosed();
			} catch (SQLException e) {
				new NercurioException(Constants.Errors.E1004_CODE, Constants.Errors.E1004_DESC, e);
			}
		}
		
		if (o instanceof Statement){
			try {
				return ((Statement)o).isClosed();
			} catch (SQLException e) {
				new NercurioException(Constants.Errors.E1005_CODE, Constants.Errors.E1005_DESC, e);
			}
		}
		
		return false;
	}
	
	public static boolean isNotEmpty(Object o){
		return !isEmpty(o);
	}
	
	public static Preferences getPreferences(){
		Preferences preferences = ConfigurationScope.INSTANCE
				.getNode(Constants.Configurations.PREFERENCES_CONFIGURATION_ID);
		Preferences pref = preferences.node(Constants.Configurations.PREFERENCES_CONFIGURATION_NODE);
		
		return pref;
	}
}
