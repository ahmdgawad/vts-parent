package com.alten.vts.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alten.vts.dto.VehicleDTO;
import com.alten.vts.service.VehicleService;

@RequestMapping("/vehicles")
@RestControllerAdvice
@RestController
public class VehicleResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(VehicleResource.class);

	@Autowired
	private VehicleService vehicleService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/all")
	public List<VehicleDTO> all() {
		return vehicleService.all();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public VehicleDTO get(@PathVariable long id) {
		return vehicleService.get(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public VehicleDTO put(@PathVariable long id, @RequestBody VehicleDTO VehicleDTO) {
		VehicleDTO.setId(id);
		return vehicleService.save(VehicleDTO);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		vehicleService.delete(id);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public VehicleDTO add(@RequestBody VehicleDTO VehicleDTO) {
		return vehicleService.save(VehicleDTO);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Throwable ex) {
		LOG.error("There was an error: ", ex);
		// Add conditional logic to show differnt status on different exceptions
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
