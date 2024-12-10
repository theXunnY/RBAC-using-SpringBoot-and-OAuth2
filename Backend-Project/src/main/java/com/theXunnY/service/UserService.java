package com.theXunnY.service;

import java.util.List;
import java.util.Optional;

import com.theXunnY.entity.User;

public interface UserService {

	public User saveUser(User user);
	 
	public List<User> getAllUsers();
	 
	public Optional<User> findById(long id);

	public User updateUser(User user);
	
	public User findByEmail(String email);

	User updateUser(long id, User user);
	
	public void deleteUser(long id);
	 
	 
}
