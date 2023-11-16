package assessment.com.taskservice.service.task;

import assessment.com.taskservice.api.task.request.TaskRequest;
import assessment.com.taskservice.api.task.request.TaskIdRequest;
import assessment.com.taskservice.dto.TaskDto;

import java.util.List;

public interface TaskService {
    public List<TaskDto> getAllTasks ();
    public TaskDto getTaskById(Long taskId);
    public Boolean createTask(TaskRequest createTaskRequest);
    public Boolean updateTaskById(TaskIdRequest taskIdRequest, TaskRequest taskRequest);
    public void deleteTaskById(TaskIdRequest taskIdRequest);
}
