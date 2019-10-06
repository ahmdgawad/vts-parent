package com.alten.vts.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import com.alten.vts.dto.CustomerDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@EmbeddedKafka
public class CustomerServiceTest {
	
	@Autowired
    CustomerService customerService;
	
	@Test
    public void testAll() {
		customerService.all();
    }
	
	@Test
	public void testSave() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName("Ahmed");
		customerDTO.setLastName("Gawad");
		customerDTO.setAddress("Cairo, Egypt");
		
		customerService.save(customerDTO);
	}

}
