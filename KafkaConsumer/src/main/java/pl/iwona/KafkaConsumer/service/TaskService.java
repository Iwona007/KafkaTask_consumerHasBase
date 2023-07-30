package pl.iwona.KafkaConsumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.iwona.KafkaConsumer.domain.Task;
import pl.iwona.KafkaConsumer.repository.TaskRepository;

@Slf4j
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void persistTask(Task task) {
        Task persistedTask = taskRepository.save(task);
        log.info("new task persisted {}", persistedTask);
    }

}
