package assessment.com.taskservice.api.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String errorId;
    private String message;
    private String details;
}
