package assessment.com.taskservice.api.task.response;

import assessment.com.taskservice.dto.TaskDto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class GetTaskByIdResponse {
    private TaskDto task;
}
