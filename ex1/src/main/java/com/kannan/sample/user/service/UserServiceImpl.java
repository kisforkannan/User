package com.kannan.sample.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kannan.sample.user.dao.UserRepo;
import com.kannan.sample.user.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepository;

	@Override
	public List<User> findByName(String name) {
		return (List<User>) userRepository.findByUserName(name);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public boolean isUserExist(User user) {
		return findByName(user.getUserName()) != null;
	}

}
