package com.ivanceras.commons.conf;

import com.ivanceras.commons.conf.DBConfig;

/**
 * TODO: fixe this, better use Properties than Strings
 * @author lee
 *
 */
public class Configuration {
	
	public String baseDirectory;
	
	public String daopackageName;
	public String metaDataPackageName;
	public String bopackageName;
	public String mapperpackageName;
	private String generatedDirectory;
	public String metaDataClassName;
	
	public String dbType;
	public String dbHost;
	public String dbPort;
	public String dbName;
	public String dbUser;
	public String dbPassword;
	
	public String[] includeSchema;

	public Boolean enableCache;
	public Boolean enableRecordChangelog;
	public String etcCustomConfigurationFile;
	public String applicationDictionarySchema;

	public String daodirectory;
	public String metaDataDirectory;
	private String metaDataFolder;
	public String bodirectory;
	public String mapperdirectory;
	
	public String generatedDataDirectory;
	public String generatedDataFile;
	
	public String columnNames;
	public String log4jProperties;

	private DBConfig config;

	public boolean useCamelCase;
	public boolean sslConnection;
	
	public Configuration(String baseDirectory2, String daopackageName2,
			String mapperpackageName2, String bopackageName2,
			String metaDataPackageName2,String metaDataDirectory2, String generatedDirectory2,
			String metaDataClassName2,
			String dbType2, String dbHost2, String dbPort2, String dbName2,
			String dbUser2, String dbPassword2, String[] includeSchema2,
			Boolean enableCache2, String etcCustomConfigurationFile2, Boolean enableRecordChangelog2) {

		baseDirectory = baseDirectory2;
		daopackageName = daopackageName2;
		metaDataPackageName = metaDataPackageName2;
		bopackageName = bopackageName2;
		mapperpackageName = mapperpackageName2;
		generatedDirectory = generatedDirectory2;
		metaDataClassName = metaDataClassName2;
		metaDataFolder = metaDataDirectory2;
		dbType = dbType2;
		dbHost = dbHost2;
		dbPort = dbPort2;
		dbName = dbName2;
		dbUser = dbUser2;
		includeSchema = includeSchema2;
		dbPassword = dbPassword2;
		enableCache = enableCache2;
		etcCustomConfigurationFile = etcCustomConfigurationFile2;
		enableRecordChangelog = enableRecordChangelog2;
		init();
	}

	void init(){
		daodirectory = baseDirectory+"/"+metaDataFolder+"/"+packageToDirectory(daopackageName);
		metaDataDirectory = baseDirectory+"/"+metaDataFolder+"/"+packageToDirectory(metaDataPackageName);
		bodirectory = baseDirectory+"/"+generatedDirectory+"/"+packageToDirectory(bopackageName);
		mapperdirectory = baseDirectory+"/"+generatedDirectory+"/"+packageToDirectory(mapperpackageName);
		generatedDataDirectory = baseDirectory+"/gen/data/";
		generatedDataFile = "data.xml";
	}
	
	public static String packageToDirectory(String packageName){
		return packageName.replace(".", "/");
	}
	
	public DBConfig getDBConfig() {
		if(config == null){
			this.config = new DBConfig(dbType, dbHost, dbPort, dbName, dbUser, dbPassword);
			this.config.setSslConnection(sslConnection);
			this.config.setOverwriteFile(etcCustomConfigurationFile);
		}
		return this.config;
	}


}
