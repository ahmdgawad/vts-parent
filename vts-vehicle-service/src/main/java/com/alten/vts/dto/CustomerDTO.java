package com.alten.vts.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long custId;
	
	private String custAddress;
	
	private String custFirstName;
	
	private String custLastName;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
}
