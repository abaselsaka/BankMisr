package banquemisr.challenge05.banquemisr.service.impl;

import banquemisr.challenge05.banquemisr.dto.TaskDto;
import banquemisr.challenge05.banquemisr.entity.Task;
import banquemisr.challenge05.banquemisr.exception.ResourceNotFoundException;
import banquemisr.challenge05.banquemisr.repository.TaskRepository;
import banquemisr.challenge05.banquemisr.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TaskRepository taskRepository ;

    @Override
    public TaskDto addTask(TaskDto taskDto) {

        // convert taskDto into task Jpa entity
        Task task = modelMapper.map(taskDto, Task.class);

        // task Jpa entity
        Task savedTask = taskRepository.save(task);

        // Convert saved task Jpa entity object into taskDto object

        TaskDto savedtaskDto = modelMapper.map(savedTask, TaskDto.class);

        return savedtaskDto ;
    }
    @Override
    public TaskDto getTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not found with id:" + id));

        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map((task) -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto, Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not found with id : " + id));
        task .setTitle(taskDto.getTitle());
        task .setDescription(taskDto.getDescription());
        task .setPriority(taskDto.getPriority());
        task .setStatus(taskDto.getStatus());
        task .setDueDate(taskDto.getDueDate());
       Task updatedTask  = taskRepository.save(task);
        return modelMapper.map(updatedTask, TaskDto.class);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not found with id : " + id));
        taskRepository.deleteById(id);
    }
}
