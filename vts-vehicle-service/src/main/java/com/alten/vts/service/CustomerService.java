package com.alten.vts.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.vts.datamodel.Customer;
import com.alten.vts.dto.CustomerDTO;
import com.alten.vts.messagelistener.CustomerMessageListener;
import com.alten.vts.repository.CustomerVSRepository;

@Service
public class CustomerService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CustomerVSRepository customerVSRepository;

	public CustomerDTO save(CustomerMessageListener.Customer customer) {
		Customer customer2 = customerVSRepository.save(modelMapper.map(customer, Customer.class));
		return modelMapper.map(customer2, CustomerDTO.class);
	}

}
