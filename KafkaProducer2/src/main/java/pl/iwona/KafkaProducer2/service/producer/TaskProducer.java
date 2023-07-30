package pl.iwona.KafkaProducer2.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.iwona.KafkaProducer2.domain.Task;

@Slf4j
@Component
public class TaskProducer {

    @Value("${topic.name}")
    private String newTask;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public TaskProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }
    public String sendMessage(Task task) throws JsonProcessingException {
        String taskAsMessage = objectMapper.writeValueAsString(task);
        kafkaTemplate.send(newTask, taskAsMessage);
        log.info("new task produced {}", taskAsMessage);
        return "message sent";
    }
}
