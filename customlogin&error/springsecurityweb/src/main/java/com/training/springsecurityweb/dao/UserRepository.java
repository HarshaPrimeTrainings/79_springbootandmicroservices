package com.training.springsecurityweb.dao;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserInfo, Integer>{

	public UserInfo findByUname(String uname);
}
