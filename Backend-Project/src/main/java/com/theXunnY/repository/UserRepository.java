package com.theXunnY.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theXunnY.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
