package com.kannan.sample.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kannan.sample.user.service.UserService;
import com.kannan.sample.user.util.Custom204Exception;
import com.kannan.sample.user.util.CustomResponseEntity;
import com.kannan.sample.user.vo.User;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAllUsers() throws Custom204Exception {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			throw new Custom204Exception("No user found");
		}
		return buildResponseEntity(users);
	}

	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUser(@PathVariable("name") String name) throws Custom204Exception {
		List<User> users = userService.findByName(name);
		if (users.isEmpty()) {
			throw new Custom204Exception("User Name " + name + " not found");
		}
		return buildResponseEntity(users);
	}

	private ResponseEntity<?> buildResponseEntity(List<User> users) {
		CustomResponseEntity response = new CustomResponseEntity(HttpStatus.OK);
		response.setMessage("Success");
		response.setData(users);
		return new ResponseEntity<>(response, response.getStatus());
	}

}
