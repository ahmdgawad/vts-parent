package com.alten.vts.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alten.vts.datamodel.Customer;
import com.alten.vts.datamodel.Vehicle;
import com.alten.vts.dto.VehicleDTO;
import com.alten.vts.messagelistener.CustomerMessageListener;

@Configuration
public class CommonConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		TypeMap<com.alten.vts.messagelistener.CustomerMessageListener.Customer, Customer> customerTypeMap = modelMapper
				.createTypeMap(com.alten.vts.messagelistener.CustomerMessageListener.Customer.class, Customer.class);
		customerTypeMap.addMappings(new PropertyMap<CustomerMessageListener.Customer, Customer>() {

			@Override
			protected void configure() {
				map().setCustId(source.getId());
				map().setCustFirstName(source.getFirstName());
				map().setCustLastName(source.getLastName());
				map().setCustAddress(source.getAddress());
			}
		});

		TypeMap<Vehicle, VehicleDTO> vehicleTypeMap = modelMapper.createTypeMap(Vehicle.class, VehicleDTO.class);
		vehicleTypeMap.addMappings(new PropertyMap<Vehicle, VehicleDTO>() {

			@Override
			protected void configure() {
				map().setStatus(source.getStatus().getStatusName());
			}
		});
		return modelMapper;
	}

}
