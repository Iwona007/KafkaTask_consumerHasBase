package pl.iwona.KafkaProducer2.domain;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Task {

    String input;

    String pattern;

}
