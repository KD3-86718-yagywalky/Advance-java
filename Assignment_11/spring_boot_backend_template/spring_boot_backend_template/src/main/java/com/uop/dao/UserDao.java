package com.uop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uop.pojos.User;

public interface UserDao extends JpaRepository<User, Long>{

}
