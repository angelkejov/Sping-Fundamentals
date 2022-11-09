package com.example.examfinal.web;

import com.example.examfinal.model.entity.CityEntity;
import com.example.examfinal.model.entity.UserEntity;
import com.example.examfinal.model.entity.enums.CapitalOrNot;
import com.example.examfinal.repository.CityRepository;
import com.example.examfinal.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WithMockUser("admin")
@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CityRepository cityRepository;

    @AfterEach
    void tearDown() {
        cityRepository.deleteAll();
    }

    @Test
    void testOpenAllPlaces() throws Exception {
        mockMvc.
                perform(get("/cities/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("places"));
    }


}
