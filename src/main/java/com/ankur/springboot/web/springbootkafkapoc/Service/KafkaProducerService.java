package com.ankur.springboot.web.springbootkafkapoc.Service;

import com.ankur.springboot.web.models.*;
import com.ankur.springboot.web.springbootkafkapoc.AppConfigs;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaProducerService {

    @Autowired
    private AppConfigs configs;

    @Bean
    public Map<String, Object> kafkaProducerConfig() {
        Map<String, Object> configProps = new HashMap<>();
        // configProps.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs.applicationID);
        configProps.put(ProducerConfig.CLIENT_ID_CONFIG, configs.getApplicationID());
        // configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, configs.getBootstrapServers());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        // configProps.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConfigs.schemaRegistryServers);
        configProps.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, configs.getSchemaRegistryServers());
        return configProps;
    }

    public boolean sendMessage(DeliveryAddress deliveryAddress) {
        KafkaProducer<String, com.ankur.springboot.web.models.DeliveryAddress> kafkaProducer = new KafkaProducer<>(kafkaProducerConfig());
        // kafkaProducer.send(new ProducerRecord<>(AppConfigs.topicNameDelivery, null, deliveryAddress));
        kafkaProducer.send(new ProducerRecord<>(configs.getTopicNameDelivery(), null, deliveryAddress));
        kafkaProducer.flush();
        kafkaProducer.close();
        return true;
    }

    public boolean sendMessage(Customer customer) {
        KafkaProducer<String, com.ankur.springboot.web.models.Customer> kafkaProducer = new KafkaProducer<>(kafkaProducerConfig());
        // kafkaProducer.send(new ProducerRecord<>(AppConfigs.topicNameCustomer, null, customer));
        kafkaProducer.send(new ProducerRecord<>(configs.getTopicNameCustomer(), null, customer));
        kafkaProducer.flush();
        kafkaProducer.close();
        return true;
    }
}
