package com.online.bsms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.bsms.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
	public User findByEmail(String email);

}