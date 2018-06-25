package com.kannan.sample.user.service;

import java.util.List;

import com.kannan.sample.user.vo.User;

public interface UserService {

	List<User> findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();

	boolean isUserExist(User user);
}
