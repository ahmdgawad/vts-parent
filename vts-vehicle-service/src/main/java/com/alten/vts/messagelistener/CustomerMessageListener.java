package com.alten.vts.messagelistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.alten.vts.service.CustomerService;
import com.google.gson.Gson;

@Service
public class CustomerMessageListener {
	@Autowired
	private CustomerService customerService;

	@KafkaListener(topics = "CustomerCreated")
	public void handle(String json) {
		Gson gson =new Gson();
		Customer customer = gson.fromJson(json, Customer.class);
		System.out.println("Received: " + customer);
		customerService.save(customer);
	}

	public static class Customer {

		private long id;
		private String firstName;
		private String lastName;
		private String address;

		public long getId() {
			return id;
		}

		public void setId(long id) {
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
		
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

	}
}
