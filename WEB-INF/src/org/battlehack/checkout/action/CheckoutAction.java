/*
 * Function:  Struts2 Getting Started - form_processing_db
 * Ref.:      https://struts.apache.org/docs/processing-forms.html
 * Version    1.1  2015/06/11  T.Hayashi  Created from HelloWorldAction
 */


package org.battlehack.checkout.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Environment;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Acts as a Struts 2 controller that responds
 * to a user action by setting the value
 * of the Message model class, and returns a String
 * result.
 * @author Bruce Phillips
 *
 */
public class CheckoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/* Log */
	private Log log = LogFactory.getLog(this.getClass());

	// merchant ID, public key and private key are of sand-box.
    private static BraintreeGateway gateway = new BraintreeGateway(
            Environment.SANDBOX,
            "66kwgny58y9r3r2k",
            "y723g5fnjnc5qms2",
            "15cc2ecbd404c2a6ca3a58b5f4cf377a"
        );

	private String clientToken;


	/*
	 * Creates the MessageStore model object,
	 * increase helloCount by 1 and
	 * returns success.  The MessageStore model
	 * object will be available to the view.
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {

		log.info("[CheckoutAction.execute()]");
		this.post();

//		helloCount++;
//
//		Employee employee = selectEmp();
//
//		String name = null;
//		if (employee != null) {
//			name = ", " + employee.getFirstName() + " " + employee.getLastName();
//		}
//
//		messageStore = new MessageStore() ;
//
//		//Action included a query string parameter of userName
//		//or a form field with name of userName
//		if (name != null) {
//			messageStore.setMessage( messageStore.getMessage() + name);
//		}

		return SUCCESS;
	}


	private void post() {
		  this.clientToken = gateway.clientToken().generate();

		  // This is for case with an existing customer
//		  String aCustomerId = "12345";
//		  ClientTokenRequest clientTokenRequest = new ClientTokenRequest()
//		      .customerId(aCustomerId );
//		  String clientTokenGenerated =  gateway.clientToken().generate(clientTokenRequest);
//		  System.out.println("[CheckoutAction.post:L86]clientTokenGenerated = " + clientTokenGenerated);

	}


	/**
	 * @return clientToken
	 */
	public String getClientToken() {
		return clientToken;
	}

	/**
	 * @param clientToken ƒZƒbƒg‚·‚é clientToken
	 */
	public void setClientToken(String clientToken) {
		this.clientToken = clientToken;
	}


}
