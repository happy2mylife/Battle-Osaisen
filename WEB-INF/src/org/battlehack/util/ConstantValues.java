/*
 * Function: Constant values
 *
 * Version 1.0  2015/06/09  T.Hayashi  Created
 */

package org.battlehack.util;

/**
 * This class contains constant values
 * @author  T.Hayashi
 * @version 1.0, 2010/06/01
 */
public class ConstantValues {

	/** Session time out time */
	public static final long SESSIONTIMEOUT = 10 * 60 * 1000; // 10 minutes
//	public static final long  SESSIONTIMEOUT = 20 * 1000; // 20 seconds

	/** Temporary user ID as it is being null */
	public static final String LC_NULL = "LoginController got from session is null";


	/** Constant value to switch HOST_DB */
	public static String HOST_DB = "COSDELLSRVVBBH_Postgres";

	/** Host and DB to be used */
	public static final String COSDELLSRVVBBH_POSTGRES 		= "COSDELLSRVVBBH_Postgres";


	/** Constant value to switch connection method to database */
//	public static String CONNECTIONMETHOD = "DriverManager";
	public static final String CONNECTIONMETHOD = "DataSource";

	// Connection method
	/** DriverMananger method */
	public static final String DRIVERMANAGER = "DriverManager";
	/** DataSource method */
	public static final String DATASOURCE = "DataSource";

	/** Number of product shown at one page on order.jsp/purchase.jsp */
	public static final int OFFSET = 20;

	/** Initial value of startNum */
	public static final int INITIAL_STARTNUM = 1;

	/** Max number for stock */
	public static final int MAX_STOCK = 99999;

}
