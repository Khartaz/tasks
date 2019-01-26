package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTestSuite {
    @Autowired
    private TaskRepository repository;

    @Test
    public void saveTask() {
        //Given
        Task task = new Task("test", "test");
        //When
        repository.save(task);
        //Then
        long id = task.getId();
        Task readTask = repository.findOne(id);
        assertEquals(task.getTitle(), readTask.getTitle());
        assertEquals(task.getContent(), readTask.getContent());
        //CleanUp
        repository.delete(id);
    }

}