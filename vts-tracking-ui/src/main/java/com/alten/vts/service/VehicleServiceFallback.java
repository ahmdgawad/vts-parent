package com.alten.vts.service;

import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import com.alten.vts.dto.VehicleDTO;

@Service
public class VehicleServiceFallback implements VehicleService {
	
    @Override
    public Resources<VehicleDTO> findAll() {
        return null;
    }

    @Override
    public VehicleDTO add(VehicleDTO vehicle) {
        return null;
    }

    @Override
    public VehicleDTO update(Long id, VehicleDTO vehicle) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

}
