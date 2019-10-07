package com.alten.vts.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alten.vts.dto.VehicleDTO;

@Service
public class SimulatorService {
	
	@Autowired
	private VehicleService vehicleService;
	
	private Random random = new Random();
	
	@Scheduled(fixedRate = 10000)
    public void pingVehicle() {
		
		List<String> statusTypes = Arrays.asList("CONNECTED", "DISCONNECTED");

        List<VehicleDTO> vehicleList = vehicleService.findAll();

        int vehicleSize = random.nextInt(vehicleList.size() - 1) + 1;

        for (int i = 0; i < vehicleSize; i++) {
            int randomIndex = random.nextInt(vehicleList.size());
            
            VehicleDTO vehicle = vehicleList.get(randomIndex);
            vehicle.setLastUpdated(new Date());
            vehicle.setStatus(statusTypes.get(random.nextInt(statusTypes.size())));
            
            vehicleService.update(vehicle.getId(), vehicle);
        }

    }

}
