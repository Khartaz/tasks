package com.crud.tasks.controller;

import com.crud.tasks.controller.facade.TaskFacade;
import com.crud.tasks.domain.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1/task")
public class TaskController {
    @Autowired
    private TaskFacade taskFacade;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return taskFacade.getTasks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTaskById")
    public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException {
        return taskFacade.getTask(taskId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(@RequestParam Long taskId) {
        taskFacade.deleteTask(taskId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskFacade.updateTask(taskDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask", consumes = APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto) {
        taskFacade.createTask(taskDto);
    }
}
