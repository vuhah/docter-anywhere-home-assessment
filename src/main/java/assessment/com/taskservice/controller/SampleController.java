package assessment.com.taskservice.controller;

import assessment.com.taskservice.api.sample.SampleResponse;
import assessment.com.taskservice.service.sample.SampleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.concurrent.Callable;

@RestController
@Validated
@RequiredArgsConstructor
@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/v1/tasking-service/hello-world")
public class SampleController {
    private static final String API_STATUS_KEY = "apiStatus";

    private final SampleService sampleService;
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("")
    public Callable<ResponseEntity<SampleResponse>> getHelloWorld(
            @RequestHeader final HttpHeaders requestHeader,
            final HttpServletRequest request
            ){
        return () -> {
            logger.info("Received request to /v1/tasking-service/hello-world");
            request.setAttribute(API_STATUS_KEY, HttpStatus.OK.toString());
            return new ResponseEntity<SampleResponse>(sampleService.getHelloWorld(), HttpStatus.OK);
        };
    }
}
