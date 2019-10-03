package com.alten.vts.dto;

import java.io.Serializable;
import java.util.Date;

public class VehicleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String vin;
	private String registrationNo;
	private long custId;
	private long statusId;
	private Date lastUpdated;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getVin() {
		return vin;
	}
	
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public String getRegistrationNo() {
		return registrationNo;
	}
	
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	
	public long getCustId() {
		return custId;
	}
	
	public void setCustId(long custId) {
		this.custId = custId;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
}
