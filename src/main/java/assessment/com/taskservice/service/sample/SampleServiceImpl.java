package assessment.com.taskservice.service.sample;

import assessment.com.taskservice.api.sample.SampleResponse;
import assessment.com.taskservice.repository.sample.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService{
    private final SampleRepository sampleRepository;

    @Override
    public SampleResponse getHelloWorld(){
        return SampleResponse.builder().message(sampleRepository.getHelloWorld()).build();
    }
}
