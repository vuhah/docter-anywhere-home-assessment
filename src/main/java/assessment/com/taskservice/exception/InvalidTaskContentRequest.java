package assessment.com.taskservice.exception;

import assessment.com.taskservice.api.task.request.TaskRequest;
import assessment.com.taskservice.constant.common.CommonConstant;
import assessment.com.taskservice.exception.baseException.BaseException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class InvalidTaskContentRequest extends BaseException {
    @Serial
    private static final long serialVersionUID = CommonConstant.SERIAL_VERSION_UID;

    public InvalidTaskContentRequest(TaskRequest taskRequest){
        super("TS-002", HttpStatus.BAD_REQUEST, "Invalid Task Id", taskRequest.toString());
    }
}
