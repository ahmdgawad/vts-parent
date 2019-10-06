package com.alten.vts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.vts.datamodel.Status;
import com.alten.vts.datamodel.Vehicle;
import com.alten.vts.dto.VehicleDTO;
import com.alten.vts.repository.VehicleRepository;

@Transactional
@Service
public class VehicleService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<VehicleDTO> all() {
		return vehicleRepository.findAll().stream().map(c -> modelMapper.map(c, VehicleDTO.class))
				.collect(Collectors.toList());
	}

	public VehicleDTO save(VehicleDTO vehicleDTO) {
		Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
		vehicle.setStatus(getStatus(vehicleDTO.getStatus()));
		
		vehicle = vehicleRepository.save(vehicle);
		return modelMapper.map(vehicle, VehicleDTO.class);
	}

	public VehicleDTO get(long vehicleId) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
		if (!vehicle.isPresent()) {
			return null;
		}
		return modelMapper.map(vehicle.get(), VehicleDTO.class);
	}

	public void delete(long vehicleId) {
		vehicleRepository.deleteById(vehicleId);
	}
	
	private Status getStatus(String statusStr) {
		return statusStr.equals("CONNECTED") ? new Status(1, "CONNECTED")
				: new Status(2, "DISCONNECTED");
	}

}
