package com.eleomanni.nercurio.utils;


public final class Constants {
	public static final class Medicine{
		public static final String TYPE_A = "A";		
		public static final String TYPE_H = "H";		
		public static final String TYPE_C = "C";		
	}
	
	public static final class Configurations{
		public static final String USER_HOME = "user.home";
		public static final String PROPERTIES_DIR = ".mercurio";
		public static final String PROPERTIES_FILENAME = "mercurio.properties";
		
		public static final int MAX_RECORDS = 50;		
	}
	
	public final class Properties{
		public static final String DB_URL = "databaseUrl";
		public static final String INIT_DB = "initDB";
	}
	
	public final class Csv{
		public static final String COMMA_SEPARATOR = ";";
		
		//MEDICINE
		public static final int FILE_TYPE_MEDICINE_A = 1;
		public static final int FILE_TYPE_MEDICINE_H = 1;
		
		public final class MedicineAFileType{
			public static final int FIELD_MED_ACTIVE_PRINCIPLE = 0;
			public static final int FIELD_MED_EQ_GROUP_DESCR = 1;
			public static final int FIELD_MED_CLASSIFICATION_PACKAGE = 2;
			public static final int FIELD_MED_PRICE = 3;
			public static final int FIELD_MED_COMPANY = 4;
			public static final int FIELD_MED_CODE = 5;
			public static final int FIELD_MED_EQ_GROUP_CODE = 6;
		}
		
		public final class MedicineHFileType{
			public static final int FIELD_MED_ACTIVE_PRINCIPLE = 0;
			public static final int FIELD_MED_EQ_GROUP_DESCR = 1;
			public static final int FIELD_MED_CLASSIFICATION_PACKAGE = 2;
			public static final int FIELD_MED_PRICE = 3;
			public static final int FIELD_MED_PRICE_EX_FACTOR = 4;
			public static final int FIELD_MED_PRICE_MAX = 5;
			public static final int FIELD_MED_COMPANY = 6;
			public static final int FIELD_MED_CODE = 7;
			public static final int FIELD_MED_EQ_GROUP_CODE = 8;
		}
	}
	
	public final class Venere{
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
		
		//CSV Loader
		public static final String E0101_CODE = "E0101";
		public static final String E0102_CODE = "E0102";
		public static final String E0103_CODE = "E0103";
		public static final String E0104_CODE = "E0104";
		
		//Venere Loader
		public static final String E0201_CODE = "E0201";
		public static final String E0202_CODE = "E0202";
		public static final String E0203_CODE = "E0203";
		
		
		//DB
		public static final String E1000_CODE = "E1000";
		public static final String E1001_CODE = "E1001";
		public static final String E1002_CODE = "E1002";
		
		
		/*DESCRIPTIONS*/ //TODO gestire località per traduzioni
		public static final String E0000_DESC = "Generic Error";
		
		//CSV Loader
		public static final String E0101_DESC = "Empty Input File";
		public static final String E0102_DESC = "File not found";
		public static final String E0103_DESC = "File I/O error";
		public static final String E0104_DESC = "Wrong file layout. Please check input file";
		
		//Venere Loader
		public static final String E0201_DESC = "Error opening Venere DB file";
		public static final String E0202_DESC = "Error reading Venere DB table";
		public static final String E0203_DESC = "Error closing Venere DB file";
		
		//DB
		public static final String E1000_DESC = "DB connection error: impossible to open JDBC data source";
		public static final String E1001_DESC = "DB insert or update error";
		public static final String E1002_DESC = "DB connection error: impossible to close JDBC data source";
	}
}
