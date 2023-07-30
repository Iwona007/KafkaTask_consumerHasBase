package pl.iwona.KafkaProducer2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.iwona.KafkaProducer2.domain.Task;
import pl.iwona.KafkaProducer2.service.producer.TaskProducer;

@Slf4j
@Service
public class TaskService {

    private final TaskProducer taskProducer;


    @Autowired
    public TaskService(TaskProducer taskProducer) {
        this.taskProducer = taskProducer;
    }

    public String createTask(Task task) throws JsonProcessingException {

     return  taskProducer.sendMessage(task);

    }
}
