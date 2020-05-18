package com.ankur.springboot.web.springbootkafkapoc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//public class AppConfigs {
//    public final static String applicationID = "Kafka-Poc";
//    public final static String topicNameDelivery = "kafka-poc-delivery";
//    public final static String topicNameCustomer = "kafka-poc-customer";
//    public final static String bootstrapServers = "localhost:9092,localhost:9093";
//    public final static String schemaRegistryServers = "http://localhost:8081";
//}

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class AppConfigs {
    private String environment;
    private String name;
    private String applicationID;
    private String topicNameDelivery;
    private String topicNameCustomer;
    private List<String> bootstrapServers;
    private String schemaRegistryServers;

    public AppConfigs(){}

    public AppConfigs(String environment, String name, String applicationID, String topicNameDelivery, String topicNameCustomer, List<String> bootstrapServers, String schemaRegistryServers) {
        this.environment = environment;
        this.name = name;
        this.applicationID = applicationID;
        this.topicNameDelivery = topicNameDelivery;
        this.topicNameCustomer = topicNameCustomer;
        this.bootstrapServers = bootstrapServers;
        this.schemaRegistryServers = schemaRegistryServers;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getName() {
        return name;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getTopicNameDelivery() {
        return topicNameDelivery;
    }

    public String getTopicNameCustomer() {
        return topicNameCustomer;
    }

    public List<String> getBootstrapServers() {
        return bootstrapServers;
    }

    public String getSchemaRegistryServers() {
        return schemaRegistryServers;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public void setTopicNameDelivery(String topicNameDelivery) {
        this.topicNameDelivery = topicNameDelivery;
    }

    public void setTopicNameCustomer(String topicNameCustomer) {
        this.topicNameCustomer = topicNameCustomer;
    }

    public void setBootstrapServers(List<String> bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public void setSchemaRegistryServers(String schemaRegistryServers) {
        this.schemaRegistryServers = schemaRegistryServers;
    }
}
