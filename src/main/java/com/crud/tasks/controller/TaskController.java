package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/v1/task"})
public class TaskController {

    @Autowired
    private DbService service;

    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/getTasks"}
    )
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTaskas());
    }

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/getTask"}
    )
    public TaskDto getTask(@RequestParam Long taskId) {
        return taskMapper.mapToTaskDto(service.findById(taskId));
    }

    @RequestMapping(
            method = {RequestMethod.DELETE},
            value = {"/deleteTask"}
    )
    public void deleteTask(@RequestParam Long taskId) {

    }

    @RequestMapping(
            method = {RequestMethod.POST},
            value = {"/createTask"},
            consumes = {"application/json"}
    )
    public void createTask(@RequestBody TaskDto taskDto) {

    }

    @RequestMapping(
            method = {RequestMethod.PUT},
            value = {"updateTask"}
    )
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return new TaskDto();
    }
}
