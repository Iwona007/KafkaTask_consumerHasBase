package pl.iwona.KafkaConsumer.config;


import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Slf4j
@EnableKafka
@Configuration
public class TaskEventConsumerConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}