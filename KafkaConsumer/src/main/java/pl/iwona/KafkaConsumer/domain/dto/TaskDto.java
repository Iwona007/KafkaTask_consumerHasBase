package pl.iwona.KafkaConsumer.domain.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class TaskDto {

    String input;

    String pattern;
}
