package com.crud.tasks.controller.facade;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskFacade {
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private DbService service;

    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    public TaskDto getTask(Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(service.getTaskById(taskId).orElseThrow(TaskNotFoundException::new));
    }

    public void deleteTask(Long taskId) {
        service.deleteTask(taskId);
    }

    public TaskDto updateTask(TaskDto taskDto) {
        return taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)));
    }

    public void createTask(TaskDto taskDto) {
        service.saveTask(taskMapper.mapToTask(taskDto));
    }
}
