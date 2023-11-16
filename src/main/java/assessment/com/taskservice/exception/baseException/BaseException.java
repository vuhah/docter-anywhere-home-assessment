package assessment.com.taskservice.exception.baseException;

import assessment.com.taskservice.constant.common.CommonConstant;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@JsonSerialize(using = BaseExceptionSerializer.class)
@Getter
public class BaseException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = CommonConstant.SERIAL_VERSION_UID;

    private final String errorId;
    private final HttpStatus status;
    private final String details;

    public BaseException(String errorId, HttpStatus status, String message, String details){
        super(message);
        this.errorId = errorId;
        this.status = status;
        this.details = details;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }
}
