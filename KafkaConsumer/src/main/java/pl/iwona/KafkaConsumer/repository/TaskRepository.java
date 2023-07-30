package pl.iwona.KafkaConsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.iwona.KafkaConsumer.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
