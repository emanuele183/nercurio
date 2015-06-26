package com.eleomanni.nercurio.utils;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;


public final class Constants {
	public static final class SQL{
		public static final String TABLE_PERSON = "person";
		public static final String TABLE_MEDICINE = "medicine";

		public static final String CREATE_TABLE_PERSON = "create table if not exists " 
				+ Constants.SQL.TABLE_PERSON 
				+ " (ID integer, "
				+"NAME string, "
				+"SURNAME string, "
				+"ADDRESS string, "
				+"CAP string, "
				+"CITY string, "
				+"REGION string, " //provincia, stato
				+"COUNTRY_CODE string, "
				+"SEX string, "
				+"BIRTHDATE date, "
				+"USL string, "
				+"DOCUMENT_NUMBER string, "
				+"DAT_SUBSCRIPTION date, "
				+"DAT_INS date, "
				+"DAT_LAST_MOD date, "
				+"DAT_DEL date"
				+ ")";
		
		public static final String CREATE_TABLE_MEDICINE = "create table if not exists " 
				+Constants.SQL.TABLE_MEDICINE 
				+" (ID integer, "
				+"CODE string, "
				+"ACTIVE_PRINCIPLE string, "
				+"EQUIVALENT_GROUP_DESCR string, "
				+"CLASSIFICATION_AND_PACKAGE string, "
				+"PRICE real, "
				+"SUPPLIER string, "
				+"CODE_EQUIVALENT_GROUP string, "
				+"TYPE string, "
				+"DAT_INS date, "
				+"DAT_LAST_MOD date, "
				+"DAT_DEL date)";
	}

	public static final class Medicine{
		//		public static final String TYPE_A = "A";		
		//		public static final String TYPE_H = "H";		
		//		public static final String TYPE_C = "C";		
	}

	public static final class Configurations{
		private static final String USER_HOME = "user.home";
		private static final String APPLICATION_HOME = ".nercurio";
		public static final String PREFERENCES_CONFIGURATION_ID = "com.eleomanni.nercurio.preferences.conf";
		public static final String PREFERENCES_CONFIGURATION_NODE = "node";
	}

	public static final class Preferences{
		public static final String TEST_VALUE = "nercurioInitTest";

		public static final String APP_NAME = "appName";
		public static final String HOMEDIR_NAME = "dbFilePath";

		//DB
		public static final String DB_SQLITE_CLASS_NAME = "dbSqLiteDriverClass";
		public static final String DB_SQLITE_URL_NAME = "dbSqLiteUrl";
		public static final String DB_SQLITE_STATEMENT_TIMEOUT = "dbSqLiteStatementTimeout";

		public static final class Default{
			public static final String APP_VALUE = "com.eleomanni.nercurio";
			public static final String HOMEDIR_VALUE = System.getProperty(Constants.Configurations.USER_HOME) 
					+ File.separator 
					+ Constants.Configurations.APPLICATION_HOME;

			//DB
			public static final String DB_SQLITE_CLASS_VALUE = "org.sqlite.JDBC";
			private static final String DB_SQLITE_SCHEMA_VALUE = "sqlite";
			private static final String DB_SQLITE_FILENAME_VALUE = "nercurio.db";
			private static final String DB_SQLITE_FILEPATH_VALUE = Constants.Preferences.Default.HOMEDIR_VALUE
					+ File.separator 
					+ Constants.Preferences.Default.DB_SQLITE_FILENAME_VALUE;
			public static final String DB_SQLITE_URL_VALUE =  "jdbc:"
					+ Constants.Preferences.Default.DB_SQLITE_SCHEMA_VALUE
					+ ":"
					+ Constants.Preferences.Default.DB_SQLITE_FILEPATH_VALUE;
			public static final String DB_SQLITE_STATEMENT_TIMEOUT = "30";
		}
	}

	public static final class Csv{
		//		public static final String COMMA_SEPARATOR = ";";
		//		
		//		//MEDICINE
		//		public static final int FILE_TYPE_MEDICINE_A = 1;
		//		public static final int FILE_TYPE_MEDICINE_H = 1;
		//		
		//		public final class MedicineAFileType{
		//			public static final int FIELD_MED_ACTIVE_PRINCIPLE = 0;
		//			public static final int FIELD_MED_EQ_GROUP_DESCR = 1;
		//			public static final int FIELD_MED_CLASSIFICATION_PACKAGE = 2;
		//			public static final int FIELD_MED_PRICE = 3;
		//			public static final int FIELD_MED_COMPANY = 4;
		//			public static final int FIELD_MED_CODE = 5;
		//			public static final int FIELD_MED_EQ_GROUP_CODE = 6;
		//		}
		//		
		//		public final class MedicineHFileType{
		//			public static final int FIELD_MED_ACTIVE_PRINCIPLE = 0;
		//			public static final int FIELD_MED_EQ_GROUP_DESCR = 1;
		//			public static final int FIELD_MED_CLASSIFICATION_PACKAGE = 2;
		//			public static final int FIELD_MED_PRICE = 3;
		//			public static final int FIELD_MED_PRICE_EX_FACTOR = 4;
		//			public static final int FIELD_MED_PRICE_MAX = 5;
		//			public static final int FIELD_MED_COMPANY = 6;
		//			public static final int FIELD_MED_CODE = 7;
		//			public static final int FIELD_MED_EQ_GROUP_CODE = 8;
		//		}
	}

	public static final class Venere{
		public static final int FILE_TYPE_VENERE_MEDICINE = 1;
		public static final int FILE_TYPE_VENERE_PATIENTS = 2;

		public final class Spefar{
			public static final String CODE 					= "CODSAN";
			public static final String CLASSIFICATION_PACKAGE 	= "SPECIALITA";
			public static final String PRICE 					= "PREZZO";
			public static final String TYPE 					= "CLASSE";

		}

		public final class Archivio{
			public static final String NAME 					= "NOME";
			public static final String SURNAME				 	= "COGNOME";
			public static final String ADDRESS 					= "INDIRIZZO";
			public static final String CAP 						= "CAP";
			public static final String CITY 					= "CITTA";
			public static final String REGION 					= "PROV";
			public static final String COUNTRY_CODE 			= "SiglaStato";
			public static final String SEX 						= "SESSO";
			public static final String BIRTHDATE 				= "DATA_NASC";
			public static final String USL 						= "USL";
			public static final String DOCUMENT_NUMBER 			= "NUM_TES";
			public static final String DAT_SUBSCRIPTION 		= "PRIMASCEL";

		}
	}

	public static final class Errors{
		/*CODES*/
		public static final String E0000_CODE = "E0000";

		//File Errors
		public static final String E0101_CODE = "E0101";
		public static final String E0102_CODE = "E0102";
		public static final String E0103_CODE = "E0103";
		public static final String E0104_CODE = "E0104";

		//Venere Loader
		public static final String E0201_CODE = "E0201";
		public static final String E0202_CODE = "E0202";
		public static final String E0203_CODE = "E0203";


		//FILE
		public static final String E1000_CODE = "E1000";
		public static final String E1001_CODE = "E1001";
		public static final String E1002_CODE = "E1002";
		public static final String E1003_CODE = "E1003";
		public static final String E1004_CODE = "E1004";
		public static final String E1005_CODE = "E1005";
		public static final String E1006_CODE = "E1006";
		public static final String E1007_CODE = "E1007";
		public static final String E1008_CODE = "E1008";


		/*DESCRIPTIONS*/ //TODO gestire località per traduzioni
		public static final String E0000_DESC = "Generic Error";

		//File Errors
		public static final String E0101_DESC = "Empty Input File";
		public static final String E0102_DESC = "File not found";
		public static final String E0103_DESC = "File I/O error";
		public static final String E0104_DESC = "Wrong file layout. Please check input file";

		//Venere Loader
		public static final String E0201_DESC = "Error opening Venere DB file";
		public static final String E0202_DESC = "Error reading Venere DB table";
		public static final String E0203_DESC = "Error closing Venere DB file";

		//DB
		public static final String E1000_DESC = "DB connection error: Driver Class not found";
		public static final String E1001_DESC = "DB connection error: SQLException getting DB connection";
		public static final String E1002_DESC = "DB statement creation error";
		public static final String E1003_DESC = "DB connection error: error while closing the connection";
		public static final String E1004_DESC = "DB connection error: error while testing if connection is closed";
		public static final String E1005_DESC = "DB connection error: error while testing if statement is closed";
		public static final String E1006_DESC = "DB connection error: error while closing the statement";
		//DB FUNCTIONAL
		public static final String E1007_DESC = "DB connection error: error while creating person table";
		public static final String E1008_DESC = "DB connection error: error while creating medicine table";
	}
}
