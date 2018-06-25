package com.kannan.sample.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kannan.sample.user.vo.User;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
	List<User> findByUserName(String name);
}
