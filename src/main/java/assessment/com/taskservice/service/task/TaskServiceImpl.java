package assessment.com.taskservice.service.task;

import assessment.com.taskservice.api.task.request.TaskRequest;
import assessment.com.taskservice.api.task.request.TaskIdRequest;
import assessment.com.taskservice.dto.TaskDto;
import assessment.com.taskservice.exception.TaskNotFoundException;
import assessment.com.taskservice.mapper.TaskMapper;
import assessment.com.taskservice.model.Task;
import assessment.com.taskservice.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public List<TaskDto> getAllTasks(){
        return TaskMapper.INSTANCE.tasksToTaskDtos(taskRepository.findAll());
    };
    @Override
    public TaskDto getTaskById(Long taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        return TaskMapper.INSTANCE.taskToTaskDto(task);
    };

    @Override
    public Boolean createTask(TaskRequest createTaskRequest){
        Task taskToCreate = TaskMapper.INSTANCE.createTaskRequestToTask(createTaskRequest);
        Task createdTask = taskRepository.save(taskToCreate);
        return createdTask.getTaskId() != null;
    };

    @Override
    public Boolean updateTaskById(TaskIdRequest taskIdRequest, TaskRequest taskRequest){
        Optional<Task> optionalTask = taskRepository.findById(taskIdRequest.getTaskId());

        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();

            // Update the fields based on the values in the TaskRequest
            existingTask.setTitle(taskRequest.getTitle());
            existingTask.setDescription(taskRequest.getDescription());
            existingTask.setCompleted(taskRequest.getCompleted() != null && taskRequest.getCompleted());

            // Save the updated task to the database
            taskRepository.save(existingTask);

            return true;
        } else {
            throw new TaskNotFoundException(taskIdRequest.getTaskId());
        }
    };
    @Override
    public void deleteTaskById(TaskIdRequest taskIdRequest){
        Optional<Task> optionalTask = taskRepository.findById(taskIdRequest.getTaskId());

        if (optionalTask.isPresent()) {
            taskRepository.delete(optionalTask.get());
        } else {
            throw new TaskNotFoundException(taskIdRequest.getTaskId());
        }
    };
}
