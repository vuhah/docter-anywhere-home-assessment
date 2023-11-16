package assessment.com.taskservice.api.task.request;

import assessment.com.taskservice.exception.InvalidTaskContentRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    @NotNull
    @Size(min = 3, max = 255)
    private String title;

    @Size(max = 1000)
    private String description;

    private Boolean completed;
}
