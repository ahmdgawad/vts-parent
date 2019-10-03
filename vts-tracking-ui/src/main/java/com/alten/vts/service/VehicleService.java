package com.alten.vts.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alten.vts.dto.VehicleDTO;

@FeignClient(value = "${vehicle-service.name:null}", url = "${vehicle-service.url:}", fallback = VehicleServiceFallback.class)
@Primary
public interface VehicleService {
	
	@RequestMapping("/vehicles")
    Resources<VehicleDTO> findAll();

    @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
    VehicleDTO add(@RequestBody VehicleDTO vehicle);

    @RequestMapping(value = "/vehicles/{id}", method = RequestMethod.PUT)
    VehicleDTO update(@PathVariable("id") Long id, @RequestBody VehicleDTO vehicle);

    @RequestMapping(value = "/vehicles/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id);

}
