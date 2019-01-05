package com.crud.tasks.controller;

import com.crud.tasks.controller.facade.TaskFacade;
import com.crud.tasks.domain.TaskDto;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaskFacade taskFacade;

    @Test
    public void shouldFetchEmptyTaskList() throws Exception {
        //Given
        List<TaskDto> taskDtos = new ArrayList<>();
        when(taskFacade.getTasks()).thenReturn(taskDtos);
        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchTaskList() throws Exception {
        //Given
        List<TaskDto> taskDtos = new ArrayList<>();
        taskDtos.add(new TaskDto(1L, "Test_title", "Test_Content"));

        when(taskFacade.getTasks()).thenReturn(taskDtos);

        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Test_title")))
                .andExpect(jsonPath("$[0].content", is("Test_Content")));
    }

    @Test
    public void shouldFetchTaskById() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test_title", "Test_content");

        when(taskFacade.getTask(1L)).thenReturn(taskDto);
        //When & Then
        mockMvc.perform(get("/v1/task/getTaskById?taskId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Test_title")))
                .andExpect(jsonPath("$.content", is("Test_content")));
    }

    @Test
    public void shouldFetchUpdateTask()  throws Exception{
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test_title2", "Test_content2");

        when(taskFacade.updateTask(anyObject())).thenReturn(taskDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(put("/v1/task/updateTask").contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Test_title2")))
                .andExpect(jsonPath("$.content", is("Test_content2")));
    }

    @Test
    public void shouldFetchCreateTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test_title2", "Test_content2");

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(post("/v1/task/createTask").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldFetchDeleteTask() throws Exception {
        //Given & When & Then
        mockMvc.perform(delete("/v1/task/deleteTask?taskId=1").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

}