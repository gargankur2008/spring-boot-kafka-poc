package com.ankur.springboot.web.springbootkafkapoc.Service;

import com.ankur.springboot.web.springbootkafkapoc.AppConfigs;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerService {

    @Bean
    public Map<String, Object> kafkaProducerConfig() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs.applicationID);
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configProps.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConfigs.schemaRegistryServers);
        return configProps;
    }

    public boolean getMessage(com.ankur.springboot.web.models.DeliveryAddress deliveryAddress) {
        KafkaProducer<String, com.ankur.springboot.web.models.DeliveryAddress> kafkaProducer = new KafkaProducer<>(kafkaProducerConfig());
        kafkaProducer.send(new ProducerRecord<>(AppConfigs.topicName, null, deliveryAddress));
        return true;
    }
}
