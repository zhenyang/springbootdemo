package com.tw;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Configuration
public class AppConfiguration {
    @Value("${dbName}")
    private String databaseName;

    @Value("${dbHost}")
    private String host;

    @Bean(name = "mongoDbFactory")
    public MongoDbFactory createMongoDbFactory() throws UnknownHostException {
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(100).maxWaitTime(100).build();
        MongoClient mongoClient = new MongoClient(host, options);
        return new SimpleMongoDbFactory(mongoClient, databaseName);
    }
}
