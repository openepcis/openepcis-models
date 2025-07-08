package io.openepcis.quarkus.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

/**
 * Producer for ObjectMapper to be used in the application.
 * This is needed for the AiEntries class from the openepcis-digital-link-converter-core dependency.
 */
@ApplicationScoped
public class ObjectMapperProducer {

    /**
     * Produces a singleton ObjectMapper instance for CDI injection.
     *
     * @return A configured ObjectMapper instance
     */
    @Produces
    @Singleton
    public ObjectMapper createObjectMapper() {
        return new ObjectMapper();
    }
}