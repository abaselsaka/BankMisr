package banquemisr.challenge05.banquemisr.service;

import banquemisr.challenge05.banquemisr.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto addTask(TaskDto customerDto);

    TaskDto getTask(Long id);

    List<TaskDto> getAllTasks();

    TaskDto updateTask(TaskDto customerDto, Long id);

    void deleteTask(Long id);

}
