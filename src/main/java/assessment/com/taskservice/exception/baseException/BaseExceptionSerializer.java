package assessment.com.taskservice.exception.baseException;

import assessment.com.taskservice.constant.common.CommonConstant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

public class BaseExceptionSerializer extends StdSerializer<BaseException> implements Serializable {
    @Serial
    private static final long serialVersionUID = CommonConstant.SERIAL_VERSION_UID;

    public BaseExceptionSerializer(){super(BaseException.class);}

    @Override
    public void serialize(BaseException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("errorId", value.getErrorId());
        gen.writeStringField("message", value.getMessage());
        gen.writeEndObject();
    }
}
