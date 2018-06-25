package com.kannan.sample.user;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kannan.sample.user.controller.UserController;

import spock.lang.Specification;

public class UserControllerTest extends Specification {
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

}
