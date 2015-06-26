package com.eleomanni.nercurio.utils;

import java.io.File;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

// for a extended example see
// https://bugs.eclipse.org/382224

public class NercurioLifeCycleManager {
	@Inject private Logger log;

	@PostContextCreate
	void postContextCreate(final IEventBroker eventBroker, IApplicationContext context) {
		// read values from the instance scope
		Preferences pref = Utils.getPreferences();
		String test1 = pref.get(Constants.Preferences.APP_NAME, Constants.Preferences.TEST_VALUE);
		//init preferences
		if (!test1.equalsIgnoreCase(Constants.Preferences.Default.APP_VALUE)){
			log.debug("Init Preferences");
			initDefaultPreferences(pref);
		}
		//init home folder
		File theDir = new File(pref.get(Constants.Preferences.HOMEDIR_NAME, Constants.Preferences.Default.HOMEDIR_VALUE));
		if (!theDir.exists()){
			log.debug("HOME Directory not found");
			log.debug("Create HOME Directory");
			if(!theDir.mkdir()){
				//FIXME manage error
				log.error("Impossible to create the properties directory");
				System.exit(0);
			}
		}
		
		//init DB
		log.debug("Init DB");
		SqliteDBUtils db = new SqliteDBUtils();
		try {
			db.initDB();
		} catch (NercurioException e) {
			//FIXME aprire finestra d'errore
			log.error(e.toString());
		}
	}

	void initDefaultPreferences(Preferences pref) {
		pref.put(Constants.Preferences.APP_NAME, Constants.Preferences.Default.APP_VALUE);
		pref.put(Constants.Preferences.DB_SQLITE_CLASS_NAME, Constants.Preferences.Default.DB_SQLITE_CLASS_VALUE);
		pref.put(Constants.Preferences.DB_SQLITE_URL_NAME, Constants.Preferences.Default.DB_SQLITE_URL_VALUE);
		pref.put(Constants.Preferences.HOMEDIR_NAME, Constants.Preferences.Default.HOMEDIR_VALUE);

		try {
			// forces the application to save the preferences
			pref.flush();
		} catch (BackingStoreException e) {
			//FIXME correggere gestione errore
			e.printStackTrace();
		}
	}
} 


