package com.ivanceras.commons.conf;

import java.util.HashMap;

import com.ivanceras.commons.conf.DBConfig;

public class DBConfig {

	public static final String DATABASETYPE = "databaseType";
	public static final String DATABASEHOST = "databaseHost";
	public static final String DATABASEPORT = "databasePort";
	public static final String DATABASENAME = "databaseName";
	public static final String DATABASEUSER = "databaseUser";
	public static final String DATABASEPASSWORD = "databasePassword";

	protected String dbType;
	protected String dbHost;
	protected String dbPort;
	protected String dbName;
	protected String dbUser;
	protected String dbPassword;
	protected String overwriteFile;
	protected boolean hasReadOverwriteFile;

	private String finalDbType;
	private String finalDbHost;
	private String finalDbPort;
	private String finalDbName;
	private String finalDbUser;
	private String finalDbPassword;
	private boolean sslConnection;
	public boolean doConnection = true; //for testing purposed only, do not create a connection when just testing SQL generated Strings

	public DBConfig(String dbType, String dbHost, String dbPort, String dbName, String dbUser, String dbPassword){
		this.dbType = dbType;
		this.dbHost = dbHost;
		this.dbPort = dbPort;
		this.dbName = dbName;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
		init();
	}
	
	public void setSslConnection(boolean ssl){
		this.sslConnection = ssl;
	}
	
	private void init(){
		this.finalDbType = this.dbType;
		this.finalDbHost = this.dbHost;
		this.finalDbPort = this.dbPort;
		this.finalDbName = this.dbName;
		this.finalDbUser = this.dbUser;
		this.finalDbPassword = this.dbPassword;
	}

	public void overwrite(HashMap<String, String> config){
		String dbType = config.get(DATABASETYPE);
		if(dbType != null && !dbType.trim().isEmpty()){
			this.finalDbType = dbType;
		}
		String dbHost = config.get(DATABASEHOST);
		if(dbHost != null && !dbHost.trim().isEmpty()){
			this.finalDbHost = dbHost;
		}
		String dbPort = config.get(DATABASEPORT);
		if(dbPort != null && !dbPort.trim().isEmpty()){
			this.finalDbPort = dbPort;
		}
		String dbName = config.get(DATABASENAME);
		if(dbName != null && !dbName.trim().isEmpty()){
			this.finalDbName = dbName;
		}
		String dbUser = config.get(DATABASEUSER);
		if(dbUser != null && !dbUser.trim().isEmpty()){
			this.finalDbUser = dbUser;
		}
		String dbPassword = config.get(DATABASEPASSWORD);
		if(dbPassword != null && !dbPassword.trim().isEmpty()){
			this.finalDbPassword = dbPassword;
		}
	}

	public String getDbType() {
		return finalDbType;

	}
	public String getDbHost() {
		return finalDbHost;

	}
	public String getDbPort() {
		return finalDbPort;

	}
	public String getDbName() {
		return finalDbName;

	}
	public String getDbUser() {
		return finalDbUser;

	}
	public String getDbPassword() {
		return finalDbPassword;
	}
	
	public boolean isSslConnection(){
		return sslConnection;
	}

	@Override
	public 	boolean equals(Object obj){
		if(super.equals(obj)){
			return true;
		}
		else{
			DBConfig other = (DBConfig) obj;
			
			if(obj != null && obj.getClass().equals(DBConfig.class)){
				if(	     other.dbType != null         && other.dbType.equals(dbType) 
						&& other.dbHost != null         && other.dbHost.equals(dbHost) 
						&& other.dbPort != null         && other.dbPort.equals(dbPort) 
						&& other.dbName != null         && other.dbName.equals(dbName) 
						&& other.dbUser != null         && other.dbUser.equals(dbUser)
						&& other.dbPassword != null     && other.dbPassword.equals(dbPassword)
						&& other.overwriteFile != null  && other.overwriteFile.equals(overwriteFile)){
					return true;
				}
				else
					if(other.finalDbType != null         && other.finalDbType.equals(finalDbType) 
					&& other.finalDbHost != null         && other.finalDbHost.equals(finalDbHost) 
					&& other.finalDbPort != null         && other.finalDbPort.equals(finalDbPort) 
					&& other.finalDbName != null         && other.finalDbName.equals(finalDbName) 
					&& other.finalDbUser != null         && other.finalDbUser.equals(finalDbUser)
					&& other.finalDbPassword != null     && other.finalDbPassword.equals(finalDbPassword)){
						return true;
					}

			}
		}
		return false;
	}

	public String getOverwriteFile() {
		return overwriteFile;
	}

	public void setOverwriteFile(String overwriteFile) {
		this.overwriteFile = overwriteFile;
	}

	public boolean isHasReadOverwriteFile() {
		return hasReadOverwriteFile;
	}

	public void setHasReadOverwriteFile(boolean hasReadOverwriteFile) {
		this.hasReadOverwriteFile = hasReadOverwriteFile;
	}
	
	@Override
	public String toString(){
		StringBuffer pass = new StringBuffer();
		for(int i = 0; i < dbPassword.length(); i++){
			pass.append("*");
		}
		return "{"+dbType+","+dbHost+", "+dbPort+", "+dbName+", "+dbUser+", "+pass+", "+overwriteFile+"}";
	}

}
