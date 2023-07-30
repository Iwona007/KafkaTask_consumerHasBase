package pl.iwona.KafkaProducer2.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.iwona.KafkaProducer2.domain.Task;
import pl.iwona.KafkaProducer2.service.TaskService;

@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {


    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public String createTask(@RequestBody Task task) throws JsonProcessingException {
        log.info("create new task request received");
      return taskService.createTask(task);

    }
}
