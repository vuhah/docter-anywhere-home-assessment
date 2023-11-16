package assessment.com.taskservice.controller;

import assessment.com.taskservice.api.task.request.TaskIdRequest;
import assessment.com.taskservice.api.task.request.TaskRequest;
import assessment.com.taskservice.api.task.response.CreateTaskResponse;
import assessment.com.taskservice.api.task.response.GetTaskByIdResponse;
import assessment.com.taskservice.api.task.response.GetTasksResponse;
import assessment.com.taskservice.api.task.response.UpdateTaskByIdResponse;
import assessment.com.taskservice.dto.TaskDto;
import assessment.com.taskservice.service.task.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@Validated
@RequiredArgsConstructor
@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/v1/tasking-service/tasks")
public class TaskController {
    private static final String API_STATUS_KEY = "apiStatus";

    private final TaskService taskService;
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("")
    public Callable<ResponseEntity<GetTasksResponse>> getAllTasks(
            @RequestHeader final HttpHeaders requestHeader,
            final HttpServletRequest request
    ){
        return () -> {
            logger.info("Received request get all tasks to /v1/tasking-service/tasks");
            request.setAttribute(API_STATUS_KEY, HttpStatus.OK.toString());
            List<TaskDto> tasks = taskService.getAllTasks();
            return new ResponseEntity<>(new GetTasksResponse(tasks), HttpStatus.OK);
        };
    }

    @GetMapping("/{id}")
    public Callable<ResponseEntity<GetTaskByIdResponse>> getTaskById(
            @RequestHeader final HttpHeaders requestHeader,
            @PathVariable(name = "id") final TaskIdRequest taskIdRequest,
            final HttpServletRequest request
    ){
        return () -> {
            logger.info("Received request get task by id to /v1/tasking-service/tasks/id");
            request.setAttribute(API_STATUS_KEY, HttpStatus.OK.toString());
            TaskDto task = taskService.getTaskById(taskIdRequest.getTaskId());
            return new ResponseEntity<>(new GetTaskByIdResponse(task), HttpStatus.OK);
        };
    }

    @PostMapping("")
    public Callable<ResponseEntity<CreateTaskResponse>> createTask(
            @RequestHeader final HttpHeaders requestHeader,
            @RequestBody @Valid  TaskRequest taskRequest,
            final HttpServletRequest request
    ){
        return () -> {
            logger.info("Received request create task to /v1/tasking-service/tasks");
            request.setAttribute(API_STATUS_KEY, HttpStatus.OK.toString());
            Boolean status = taskService.createTask(taskRequest);
            return new ResponseEntity<>(new CreateTaskResponse(status), HttpStatus.CREATED);
        };
    }


    @PutMapping("/{id}")
    public Callable<ResponseEntity<UpdateTaskByIdResponse>> updateTask(
            @PathVariable(name = "id") final TaskIdRequest taskIdRequest,
            @RequestHeader final HttpHeaders requestHeader,
            @RequestBody @Valid TaskRequest taskRequest,
            final HttpServletRequest request
    ) {
        return () -> {
            logger.info("Received request update task to /v1/tasking-service/tasks/{}", taskIdRequest.getTaskId());
            request.setAttribute(API_STATUS_KEY, HttpStatus.OK.toString());
            Boolean status = taskService.updateTaskById(taskIdRequest, taskRequest);
            return new ResponseEntity<>(new UpdateTaskByIdResponse(status), HttpStatus.OK);
        };
    }

    @DeleteMapping("/{id}")
    public Callable<ResponseEntity<Void>> deleteTask(
            @PathVariable(name = "id") final TaskIdRequest taskIdRequest,
            @RequestHeader final HttpHeaders requestHeader,
            final HttpServletRequest request
    ) {
        return () -> {
            logger.info("Received request delete task to /v1/tasking-service/tasks/{}", taskIdRequest.getTaskId());
            request.setAttribute(API_STATUS_KEY, HttpStatus.OK.toString());
            taskService.deleteTaskById(taskIdRequest);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
    }
}
