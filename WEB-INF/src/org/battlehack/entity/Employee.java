/*
 * entity.Employee
 *
 * Version 1.0    2015/06/09    T.Hayashi    Created
 */

package org.battlehack.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * This is entity class for member data
 * @author  T.Hayashi
 * @version 1.0, 2015/06/09
 */
public class Employee implements Serializable {

	/* SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/* Employee ID */
	private String id;

	/* first name */
	private String firstName;

	/* last name */
	private String lastName;

	/* email */
	private String email;

	/* phone number */
	private String phoneNumber;

	/* hire date */
	private Date hireDate;

	/* job id */
	private String jobId;

	/* salary */
	private int salary;

	/* commission pct */
	private int commissionPct;

	/* manager id */
	private int managerId;

	/* department id */
	private int departmentId;


	/* Constructor */
	public Employee() {
	}

	/*
	 * Constructor
	 * @param id Member ID
	 * @param firstName first name
	 */
	public Employee(String id, String firstName) {
		this.id = id;
		this.firstName = firstName;
	}

	/*
	 * Constructor
	 * @param id Member ID
	 * @param password Member password
	 * @param name Member name
	 */
	public Employee(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(int commissionPct) {
		this.commissionPct = commissionPct;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
}
