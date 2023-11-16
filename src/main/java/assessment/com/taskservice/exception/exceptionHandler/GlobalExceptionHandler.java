package assessment.com.taskservice.exception.exceptionHandler;

import assessment.com.taskservice.api.error.ErrorResponse;
import assessment.com.taskservice.api.task.request.TaskRequest;
import assessment.com.taskservice.exception.InvalidTaskContentRequest;
import assessment.com.taskservice.exception.baseException.BaseException;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                new Date(),
                ex.getErrorId(),
                ex.getMessage(),
                ex.getDetails());

        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
}
