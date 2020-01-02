package com.demo.controller;

import com.demo.BaseUnitTest;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends BaseUnitTest {

    private static final Logger LOGGER = Logger.getLogger(UserControllerTest.class);

    @Test
    void getUser() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/user/getUser")
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "1")).andExpect(status().isOk()).andReturn();
        LOGGER.info(result.getResponse().getContentAsString());
        Assertions.assertNotNull(result.getResponse().getContentAsString());
    }

}
