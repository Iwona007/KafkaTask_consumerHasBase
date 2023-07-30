package pl.iwona.KafkaConsumer.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.iwona.KafkaConsumer.domain.Task;
import pl.iwona.KafkaConsumer.domain.dto.TaskDto;
import pl.iwona.KafkaConsumer.service.TaskService;

@Slf4j
@Component
public class Consumer {

    private static final String taskTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final TaskService taskService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, TaskService taskService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.taskService = taskService;
    }

    @KafkaListener(topics = taskTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);
        TaskDto taskDto = objectMapper.readValue(message, TaskDto.class);
        Task task = modelMapper.map(taskDto, Task.class);
        taskService.persistTask(task);
    }

}
