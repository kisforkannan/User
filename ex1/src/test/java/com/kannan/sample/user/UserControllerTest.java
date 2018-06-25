package com.kannan.sample.user;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	private static String successResponse = "{\"status\":\"OK\",\"message\":\"Success\",\"data\":[{\"id\":1,\"userName\":\"Kannan\",\"status\":\"Active\"}]}";
	private static String failureResponse = "{\"status\":\"NO_CONTENT\",\"message\":\"User Name Kannan1 not found\",\"data\":null}";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnSuccessMessage() throws Exception {
		this.mockMvc.perform(get("/api/user")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Success")));
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/api/user/Kannan")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Kannan")));
	}

	@Test
	public void shouldReturnSuccess() throws Exception {
		this.mockMvc.perform(get("/api/user/Kannan")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Success"))).andExpect(content().string(successResponse));
	}

	@Test
	public void shouldReturnFailure() throws Exception {
		this.mockMvc.perform(get("/api/user/Kannan1")).andDo(print()).andExpect(status().is4xxClientError())
				.andExpect(content().string(failureResponse));
	}
}
