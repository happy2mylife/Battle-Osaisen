/*
 * dao.common.ConnectionManager
 *
 * Version 1.0  2015/06/09  T.Hayashi  Created
 */

package org.battlehack.dao.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.battlehack.util.ConstantValues;


/**
 * This is a class to connect database in Singleton pattern
 * @author  T.Hayashi
 * @version 1.0, 2015/06/09
 */
public class ConnectionManager {

	/** Log */
	private Log log = LogFactory.getLog(this.getClass());

	/** Connection information - Driver name */
	private String DRIVERNAME = null;
	/** Connection information - URL */
	private String URL = null;
	/** Connection information - USER */
	private String USER = null;
	/** Connection information - PASSWORD */
	private String PASSWORD  = null;

	/** Instance of this class(Singleton pattern) */
	private static ConnectionManager instance = null;


	/**
	 * Private constructor in Singleton pattern
	 * @throws ClassNotFoundException generated as corresponding driver was not found
	 */
	private ConnectionManager() throws ClassNotFoundException{
		if (ConstantValues.CONNECTIONMETHOD.equals(ConstantValues.DRIVERMANAGER)) {

			if (ConstantValues.HOST_DB.equals(ConstantValues.COSDELLSRVVBBH_POSTGRES)) {
				this.DRIVERNAME = "org.postgresql.Driver";
			}

			Class.forName(this.DRIVERNAME);
		}
	}


	/**
	 * Getting this class, ConnectionManager
	 * @return instance of this class
	 * @throws ClassNotFoundException
	 */
	public static ConnectionManager getConnectionManager() throws ClassNotFoundException{
		if(instance == null){
			try{
				instance = new ConnectionManager();
			} catch(ClassNotFoundException e){
				e.printStackTrace();
				throw e;
			}
		}
		return instance;
	}


	/**
	 * Return Database connection
	 * @return Database connection
	 * @throws SQLException DriverManager.getConnection(URL, USER, PASSWORD) would generate SQLException
	 * @throws NamingException
	 */
	public synchronized Connection getConnection() throws SQLException, NamingException {

		Connection con = null;
		DataSource ds = null;

		if (ConstantValues.CONNECTIONMETHOD.equals(ConstantValues.DRIVERMANAGER)) {

			// Switch code for databases
			if (ConstantValues.HOST_DB.equals(ConstantValues.COSDELLSRVVBBH_POSTGRES)) {
				URL = "jdbc:postgresql://192.168.1.191:5432/battlehack";
				USER = "postgresht";
				PASSWORD = "postgresht";
			}

			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} else if (ConstantValues.CONNECTIONMETHOD.equals(ConstantValues.DATASOURCE)) {

			try {
				InitialContext ic = new InitialContext();

				String JNDIName = null;
				if (ConstantValues.HOST_DB.equals(ConstantValues.COSDELLSRVVBBH_POSTGRES)) {
					JNDIName = "java:comp/env/JDBC_BattleHack_Postgres_COSDELLSRVVBBH";
				}

				ds = (DataSource) ic.lookup(JNDIName);
				con = ds.getConnection();

			} catch (NamingException e) {
				// The contents of log doesn't include id, because this phase could be before login
				log.warn("[ConnectionManager]", e);
				throw e;
			}
		}

		return con;
	}

}
