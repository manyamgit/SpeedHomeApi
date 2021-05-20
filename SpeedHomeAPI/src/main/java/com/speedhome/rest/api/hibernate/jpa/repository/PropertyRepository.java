package com.speedhome.rest.api.hibernate.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.speedhome.rest.api.hibernate.jpa.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer>{

}
