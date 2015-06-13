/*
 * dao.MemberDAO
 *
 * Version 1.0    2010/12/03    T.Hayashi    Version comments were cleared on procuresys059eucjp
 */

package org.battlehack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.battlehack.entity.Employee;
import org.battlehack.exception.EmployeeNotFoundException;


/**
 * This is DAO class for member table
 * @author  T.Hayashi
 * @version 1.0, 2015/06/09
 */
public class EmployeeDAO {

	/* Connection */
	private Connection con;


	/*
	 * Constructor
	 * @param con database connection
	 */
	public EmployeeDAO(Connection con) {
		this.con = con;
	}


	/*
	 * Selecting a member from member table using the argument
	 * @param  id  member ID
	 * @return member
	 * @throws SQLException pstmt.executeQuery() would generate this Exception
	 * @throws EmployeeNotFoundException generated as employee is not found having the id
	 */
	public Employee selectMember(String employeeId) throws SQLException, EmployeeNotFoundException {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Employee employee = null;
		String sql = "select EMPLOYEE_ID, FIRST_NAME, LAST_NAME from EMPLOYEES where EMPLOYEE_ID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employeeId);
			res = pstmt.executeQuery();

			if (res.next()) {
				employee = new Employee(res.getString("EMPLOYEE_ID"), res.getString("FIRST_NAME"), res.getString("LAST_NAME"));

			} else {
				throw new EmployeeNotFoundException();
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return employee;

	}


//	/*
//	 * Confirm whether id is invalid
//	 * @param iemployeeIdd
//	 * @return true: employeeId is invalid, false: employeeId is valid
//	 */
//	private boolean isInvalidId(String employeeId) {
//
//		if (!((0 < employeeId.length()) && (employeeId.length() <= 3))) {
//			return true;
//		}
//
//		return false;
//	}
}
