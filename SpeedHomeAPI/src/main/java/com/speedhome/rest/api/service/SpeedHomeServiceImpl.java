package com.speedhome.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speedhome.rest.api.hibernate.jpa.entity.Property;
import com.speedhome.rest.api.hibernate.jpa.entity.UserData;
import com.speedhome.rest.api.hibernate.jpa.repository.PropertyRepository;
import com.speedhome.rest.api.hibernate.jpa.repository.UserDataRepository;

@Service
public class SpeedHomeServiceImpl implements SpeedHomeService {
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private UserDataRepository userDataRepository;

	@Override
	public boolean validateToken(String username) {
		System.out.println("validateToken : username : "+username);
		UserData userData =  userDataRepository.findByUsername(username);
		System.out.println("validateToken : userData : "+userData);
		
		return userData !=null ? true : false;
	}

	@Override
	public void createProperty(Property property) {
		propertyRepository.save(property);
	}

	@Override
	public void updateProperty(Property property) {
		propertyRepository.save(property);
		
	}

	@Override
	public Property findPropertyById(int propertyId) {
		
		return propertyRepository.findById(propertyId).get();
	}
	
	
	
	
	
	

}
