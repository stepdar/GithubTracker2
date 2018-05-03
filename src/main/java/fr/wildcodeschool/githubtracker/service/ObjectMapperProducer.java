package fr.wildcodeschool.githubtracker.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.inject.Produces;


@javax.enterprise.context.ApplicationScoped
public class ObjectMapperProducer {
    @Produces
    public ObjectMapper produceObjectMapper(){
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES ,false );
    }
}
