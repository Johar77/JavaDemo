package com.johar.javawebdemo.errorhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName: UserControllerTest
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/1 22:15
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setUp(){

    }

    @Test
    public void testFindUserParamMiss() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/user/findByName")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        BaseResponse response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BaseResponse.class);
        assertThat(response.isSuccess()).isFalse();
        assertThat(response.getResultCode()).isEqualTo(ErrorCode.ERROR_PARAM_MISS.getErrorCode());
    }

    @Test
    public void testFindUserSuccess() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/user/findByName")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("name", "johar"))
                .andExpect(status().isOk())
                .andReturn();

        BaseResponse<List<UserVO>> response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BaseResponse.class);
        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getResultCode()).isEqualTo(ErrorCode.OK.getErrorCode());
    }
}
