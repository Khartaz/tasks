package com.crud.tasks.controller;

import com.crud.tasks.AbstractTest;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskControllerTestSuite extends AbstractTest {
    @Autowired
    private TaskRepository taskRepository;
    @InjectMocks
    TaskController taskController;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void testGetTasks() throws Exception {
        
    }

}
