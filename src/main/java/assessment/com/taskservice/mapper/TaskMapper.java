package assessment.com.taskservice.mapper;


import assessment.com.taskservice.api.task.request.TaskRequest;
import assessment.com.taskservice.dto.TaskDto;
import assessment.com.taskservice.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDto taskToTaskDto(Task task);

    List<TaskDto> tasksToTaskDtos(List<Task> tasks);
    @Mapping(target = "taskId", ignore = true)
    Task createTaskRequestToTask(TaskRequest createTaskRequest);
}
