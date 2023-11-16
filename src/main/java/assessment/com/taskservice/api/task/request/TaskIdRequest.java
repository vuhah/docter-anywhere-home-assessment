package assessment.com.taskservice.api.task.request;

import assessment.com.taskservice.exception.InvalidTaskIdRequest;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskIdRequest {
    @NotNull
    private Long taskId;

    public TaskIdRequest(String taskId) {
        try {
            if (taskId == null || taskId.trim().isEmpty()) {
                throw new InvalidTaskIdRequest(taskId);
            }
            this.taskId = Long.parseLong(taskId);
        } catch (NumberFormatException e) {
            throw new InvalidTaskIdRequest(taskId);
        }
    }
}
