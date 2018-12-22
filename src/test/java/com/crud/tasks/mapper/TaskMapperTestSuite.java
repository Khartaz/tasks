package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto();
        //When
        Task result = taskMapper.mapToTask(taskDto);
        //Then
        assertNotEquals(taskDto, result);
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task();
        //When
        TaskDto result = taskMapper.mapToTaskDto(task);
        //Then
        assertNotEquals(task, result);
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        List<Task> task = new ArrayList<>();
        //When
        List<TaskDto> result = taskMapper.mapToTaskDtoList(task);
        //Then
        assertEquals(task, result);
    }
}