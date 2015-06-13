/*
 * Function:  Struts2 Getting Started - form_processing_db
 * Ref.:      https://struts.apache.org/docs/processing-forms.html
 * Version    1.1  2015/06/09  T.Hayashi  Created from form_processing
 */


package org.battlehack.helloworld.action;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.battlehack.dao.EmployeeDAO;
import org.battlehack.dao.common.ConnectionManager;
import org.battlehack.entity.Employee;
import org.battlehack.helloworld.model.MessageStore;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Acts as a Struts 2 controller that responds
 * to a user action by setting the value
 * of the Message model class, and returns a String
 * result.
 * @author Bruce Phillips
 *
 */
public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/* Log */
	private Log log = LogFactory.getLog(this.getClass());

	/*
	 * The model class that stores the message
	 * to display in the view.
	 */
	private MessageStore messageStore;

	private static int helloCount = 0;

	public int getHelloCount() {
		return helloCount;
	}

	public void setHelloCount(int helloCount) {
		HelloWorldAction.helloCount = helloCount;
	}

	private String id;

	public String getUserName() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	 * Creates the MessageStore model object,
	 * increase helloCount by 1 and
	 * returns success.  The MessageStore model
	 * object will be available to the view.
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {

		helloCount++;

		Employee employee = selectEmp();

		String name = null;
		if (employee != null) {
			name = ", " + employee.getFirstName() + " " + employee.getLastName();
		}

		messageStore = new MessageStore() ;

		//Action included a query string parameter of userName
		//or a form field with name of userName
		if (name != null) {
			messageStore.setMessage( messageStore.getMessage() + name);
		}

		return SUCCESS;
	}


	private Employee selectEmp() throws SQLException {

		Employee employee = null;
		Connection con = null;

		try {
			// Getting connection to database
			ConnectionManager manager = ConnectionManager.getConnectionManager();
			con = manager.getConnection();
			log.debug("con.getAutoCommit() = " + con.getAutoCommit());

			EmployeeDAO edao = new EmployeeDAO(con);
			employee = edao.selectMember(id);

		} catch (Exception e) {
			// common operation
	    	try {
				if (con != null) {
					con.rollback();
				}
			} catch (SQLException e2) {
				log.warn("[id: " + id + "]", e2);
				throw e2;
			}
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					log.warn("[id: " + id + "]", e);

					throw  e;
				}
			}
		}
		return employee;

	}


	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}



}
