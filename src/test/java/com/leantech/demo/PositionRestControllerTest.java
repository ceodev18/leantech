package com.leantech.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leantech.demo.controller.PersonController;
import com.leantech.demo.controller.PositionController;
import com.leantech.demo.entitiy.Person;
import com.leantech.demo.entitiy.Position;
import com.leantech.demo.service.EmployeeService;
import com.leantech.demo.service.PositionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(controllers = PositionController.class)
@ActiveProfiles("test")
public class PositionRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PositionService positionService;

    @MockBean
    private EmployeeService employeeService;

    private List<Position> positionList;

    @BeforeEach
    void setUp() {
        this.positionList = new ArrayList<>();
        this.positionList.add(Position.builder().name("Position 1").id(1L).build());
        this.positionList.add(Position.builder().name("Position 2").id(2L).build());
        this.positionList.add(Position.builder().name("Position 3").build());
    }

    @Test
    void shouldFetchAllPositions() throws Exception {

        given(positionService.getAll()).willReturn(positionList);

        this.mockMvc.perform(get("/v1/api/position"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(positionList.size())));
    }

    @Test
    void whenAddNewPosition() throws Exception {

        Position position = new Position();
        position.setName("New Position");

        mockMvc.perform(post("/v1/api/position")
                .content(objectMapper.writeValueAsString(position))
                .contentType("application/json"))
                .andExpect(status().isCreated());

    }
    @Test
    void whenDeletePosition() throws Exception {

        Position position = new Position();
        position.setName("New Position");

        mockMvc.perform(delete("/v1/api/position/1"))
                .andExpect(status().isNoContent());

    }
}
