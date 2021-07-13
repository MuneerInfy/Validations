package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	
	
	
}

