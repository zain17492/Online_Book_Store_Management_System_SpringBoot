package com.bookstore.obs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.obs.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
	public User findByEmail(String email);

}
