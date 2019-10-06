package com.alten.vts.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STATUS")
public class Status {

	public Status() {
	}

	public Status(long id, String statusName) {
		this.id = id;
		this.statusName = statusName;
	}

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private String statusName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}
