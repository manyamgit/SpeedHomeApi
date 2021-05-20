package com.speedhome.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.speedhome.rest.api.bean.PropertyRequest;
import com.speedhome.rest.api.hibernate.jpa.entity.Property;
import com.speedhome.rest.api.service.SpeedHomeService;

@RestController
public class SpeedHomeController {
	
	@Autowired
	private SpeedHomeService speedHomeService;
	
	
	
	@PostMapping(path = "/create-property")
	public ResponseEntity<Object> createProperty(@RequestHeader("x-api-key") String token, @RequestBody PropertyRequest request) {

		try {

			if (speedHomeService.validateToken(token)) {
				
				speedHomeService.createProperty(transformRequestToProperty(request));
				return new ResponseEntity<Object>("Property created successfully.", HttpStatus.OK);

			} else {

				return new ResponseEntity<Object>("Invalid Token", HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception e) {

			return new ResponseEntity<Object>("Internal Server Error Occured. Please try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping(path = "/update-property/{id}")
	public ResponseEntity<Object> updateProperty(@PathVariable("id") int propertyId, @RequestHeader("x-api-key") String token, @RequestBody PropertyRequest request) {

		try {

			if (speedHomeService.validateToken(token)) {
				
				Property property = transformRequestToProperty(request);
				property.setId(propertyId);
				speedHomeService.updateProperty(property);
				return new ResponseEntity<Object>("Property updated successfully.", HttpStatus.OK);

			} else {

				return new ResponseEntity<Object>("Invalid Token", HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception e) {

			return new ResponseEntity<Object>("Internal Server Error Occured. Please try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping(path = "/approve-property/{id}")
	public ResponseEntity<Object> approveProperty(@PathVariable("id") int propertyId, @RequestHeader("x-api-key") String token) {

		try {

			if (speedHomeService.validateToken(token)) {
				
				Property property = speedHomeService.findPropertyById(propertyId);
				property.setStatus("APPROVED");
				speedHomeService.updateProperty(property);
				return new ResponseEntity<Object>("Property approved successfully.", HttpStatus.OK);

			} else {

				return new ResponseEntity<Object>("Invalid Token", HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception e) {

			return new ResponseEntity<Object>("Internal Server Error Occured. Please try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(path = "/search-property/{id}")
	public ResponseEntity<Object> searchProperty(@PathVariable("id") int propertyId, @RequestHeader("x-api-key") String token) {

		try {

			if (speedHomeService.validateToken(token)) {
				
				Property property = speedHomeService.findPropertyById(propertyId);
				return new ResponseEntity<Object>(property, HttpStatus.OK);

			} else {

				return new ResponseEntity<Object>("Invalid Token", HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception e) {

			return new ResponseEntity<Object>("Internal Server Error Occured. Please try after some time.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	private Property transformRequestToProperty(PropertyRequest request) {
		Property property = new Property();
		try {
			property.setHouseFlatNumber(request.getHouseFlatNumber());
			property.setAddress(request.getAddress());
			property.setFacing(request.getFacing());
			property.setStatus(request.getStatus());
		}catch(Exception e) {
			
		}
		return property;
	}

}
