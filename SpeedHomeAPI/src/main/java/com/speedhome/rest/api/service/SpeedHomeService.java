package com.speedhome.rest.api.service;

import com.speedhome.rest.api.hibernate.jpa.entity.Property;

public interface SpeedHomeService {
	
	public boolean validateToken(String username);
	public void createProperty(Property property);
	public void updateProperty(Property property);
	public Property findPropertyById(int propertyId);

}
