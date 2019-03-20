package com.pack;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MyControllerTest {
	
	private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		this.mockMvc=MockMvcBuilders.standaloneSetup(new MyController()).build();
	}

	@Test
	public void testHomePage()throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.view().name("index"));
	}
	
	
	@Test
	public void testMessagePage()throws Exception
	{
		this.mockMvc.perform(MockMvcRequestBuilders.get("/message")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("Hello World"));
	}
}
