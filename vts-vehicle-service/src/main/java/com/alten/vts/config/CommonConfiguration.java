package com.alten.vts.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alten.vts.datamodel.Customer;
import com.alten.vts.datamodel.Status;
import com.alten.vts.dto.StatusDTO;
import com.alten.vts.messagelistener.CustomerMessageListener;

@Configuration
public class CommonConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Status.class, StatusDTO.class);
		modelMapper.createTypeMap(StatusDTO.class, Status.class);
		TypeMap<com.alten.vts.messagelistener.CustomerMessageListener.Customer, Customer> typeMap = modelMapper
				.createTypeMap(com.alten.vts.messagelistener.CustomerMessageListener.Customer.class, Customer.class);
		typeMap.addMappings(new PropertyMap<CustomerMessageListener.Customer, Customer>() {

			@Override
			protected void configure() {
				map().setCustId(source.getId());
				map().setCustFirstName(source.getFirstName());
				map().setCustLastName(source.getLastName());
				map().setCustAddress(source.getAddress());
			}
		});
		return modelMapper;
	}

}
