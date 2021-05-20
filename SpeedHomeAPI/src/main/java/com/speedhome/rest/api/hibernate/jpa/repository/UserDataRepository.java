package com.speedhome.rest.api.hibernate.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.speedhome.rest.api.hibernate.jpa.entity.UserData;

public interface UserDataRepository extends JpaRepository<UserData, Integer>{
	
	UserData findByUsername(String username);

}
