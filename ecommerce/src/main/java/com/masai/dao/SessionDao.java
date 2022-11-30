package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.login.CurrentUserSession;



public interface SessionDao extends JpaRepository<CurrentUserSession, Integer>{
	
	public  CurrentUserSession findByUuid(String uuid);

}
