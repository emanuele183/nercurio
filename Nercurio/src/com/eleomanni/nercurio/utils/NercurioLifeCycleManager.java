package com.eleomanni.nercurio.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.equinox.app.IApplicationContext;
import org.hibernate.Session;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

import com.eleomanni.nercurio.entities.Person;

// for a extended example see
// https://bugs.eclipse.org/382224

public class NercurioLifeCycleManager {
	@Inject private Logger log;

	@PostContextCreate
	void postContextCreate(final IEventBroker eventBroker, IApplicationContext context) {
		// read values from the instance scope
		Preferences preferences = ConfigurationScope.INSTANCE
				.getNode(Constants.Configurations.PREFERENCES_CONFIGURATION_ID);
		Preferences pref = preferences.node(Constants.Configurations.PREFERENCES_CONFIGURATION_NODE);
		String test1 = pref.get(Constants.Preferences.APP_NAME, Constants.Preferences.TEST_VALUE);
		log.info("test1= " + test1);
		if (!test1.equalsIgnoreCase(Constants.Preferences.Default.APP_VALUE)){
			log.info("Init Preferences");
			initDefaultPreferences(pref);
			File theDir = new File(pref.get(Constants.Preferences.HOMEDIR_NAME, Constants.Preferences.Default.HOMEDIR_VALUE));
			if (!theDir.exists()){
				log.debug("HOME Directory not found");
				log.debug("Create HOME Directory");
				if(!theDir.mkdir()){
					//FIXME manage error
					log.error("Impossible to create the properties directory");
					System.exit(0);
				}
			}else{
				log.debug("HOME Directory already existent");
			}
			
			log.debug("Create DB file");
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();

	        Person p = new Person();
	        p.setName("NameTest");
	        p.setSurname("SurnameTest");
	        session.save(p);
	        session.getTransaction().commit();
//			initDB(pref);
		}
		String test2 = pref.get(Constants.Preferences.APP_NAME, Constants.Preferences.TEST_VALUE);
		log.info("test2= " + test2);
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

	private void initDB(Preferences pref){
		//TODO if DB file exists create backup and archive
		// create a connection source to the database
		// load the sqlite-JDBC driver using the current class loader

		Connection connection = null;
		try
		{
			Class.forName(pref.get(Constants.Preferences.DB_SQLITE_CLASS_NAME, Constants.Preferences.Default.DB_SQLITE_CLASS_VALUE));
			// create a database connection
			connection = DriverManager.getConnection(pref.get(Constants.Preferences.DB_SQLITE_URL_NAME, Constants.Preferences.Default.DB_SQLITE_URL_VALUE));
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.
			statement.executeUpdate(Constants.SQL.CREATE_TABLE_PERSON);
			statement.close();
			//TODO create the 'medicine' table structure
		}
		catch(SQLException | ClassNotFoundException e)
		{
			//FIXME correggere gestione errore
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				//FIXME correggere gestione errore
				e.printStackTrace();
			}
		}
	}
} 


