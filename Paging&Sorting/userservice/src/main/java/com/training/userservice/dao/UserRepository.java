package com.training.userservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByName(String name);
	
	public List<User> findByAddress(String address);
	
	@Query(value = "select count(*) from user where address=:addr",nativeQuery = true)
	public Integer getCountByAddress(String addr);

}
