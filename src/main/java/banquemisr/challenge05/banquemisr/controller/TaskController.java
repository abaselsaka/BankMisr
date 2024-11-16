package banquemisr.challenge05.banquemisr.controller;

import banquemisr.challenge05.banquemisr.dto.TaskDto;
import banquemisr.challenge05.banquemisr.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/task")
@AllArgsConstructor
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Build Add Task REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TaskDto> addTask(@Valid  @RequestBody TaskDto TaskDto){

        TaskDto savedtask = taskService.addTask(TaskDto);

        return new ResponseEntity<>(savedtask, HttpStatus.CREATED);
    }

    // Build Get Task REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long TaskId){
        TaskDto TaskDto = taskService.getTask(TaskId);
        return new ResponseEntity<>(TaskDto, HttpStatus.OK);
    }
    // Build Get All Tasks REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTodos(){
        List<TaskDto> tasks = taskService.getAllTasks();

        return ResponseEntity.ok(tasks);
    }
    // Build Update Task REST API

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TaskDto> updateTask(@Valid @RequestBody TaskDto TaskDto, @PathVariable("id") Long taskId){
        TaskDto updatedTask = taskService.updateTask(TaskDto, taskId);
        return ResponseEntity.ok(updatedTask);
    }

    // Build Delete task REST API
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("task deleted successfully!.");
    }




}
