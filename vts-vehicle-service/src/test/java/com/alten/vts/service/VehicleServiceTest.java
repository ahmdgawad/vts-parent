package com.alten.vts.service;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alten.vts.dto.VehicleDTO;
import com.alten.vts.messagelistener.CustomerMessageListener;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleServiceTest {
	
	@Autowired
	CustomerService customerService;

	@Autowired
	VehicleService vehicleService;

	@Before
	public void setUp() {
		CustomerMessageListener.Customer customer = new CustomerMessageListener.Customer();
		customer.setId(1L);
		customer.setFirstName("Ahmed");
		customer.setLastName("Gawad");
		customer.setAddress("Cairo, Egypt");
		
		customerService.save(customer);
	}

	@Test
	public void testAll() {
		vehicleService.all();
	}

	@Test
	public void testSave() {
		VehicleDTO vehicleDTO = new VehicleDTO();
		vehicleDTO.setCustId(1L);
		vehicleDTO.setRegistrationNo("KTO263");
		vehicleDTO.setVin("12345678");
		vehicleDTO.setLastUpdated(new Date());
		vehicleDTO.setStatus("CONNECTED");
		
		vehicleService.save(vehicleDTO);
	}

}
