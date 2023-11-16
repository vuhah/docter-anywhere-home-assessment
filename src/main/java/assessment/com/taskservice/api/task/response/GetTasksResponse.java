package assessment.com.taskservice.api.task.response;

import assessment.com.taskservice.dto.TaskDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetTasksResponse {
    private List<TaskDto> tasks;
}
