package assessment.com.taskservice.repository.sample;

import org.springframework.stereotype.Repository;

@Repository
public class SampleRepository {
    public String getHelloWorld() {
        return "Hello World";
    }
}
