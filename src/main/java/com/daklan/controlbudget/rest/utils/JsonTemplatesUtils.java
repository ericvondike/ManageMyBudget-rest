package com.daklan.controlbudget.rest.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

/**
 * Class for managing the {@link JsonNode}.
 */
@Component
public class JsonTemplatesUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonTemplatesUtils.class);


    private final ObjectMapper objectMapper;

    /**
     * Constructeur utilisé par Spring.
     *
     * @param objectMapper Injection de l'{@link ObjectMapper}.
     */
    @Autowired
    public JsonTemplatesUtils(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Parse un template json.
     *
     * @param template Chemtin vers le fichier à parser.
     * @return Le {@link JsonNode}.
     */
    public JsonNode getTemplate(String template) throws IOException {
        LOGGER.debug("Récupérartion du template : {}", template);
        URL templateUrl = this.getClass().getResource(template);
        JsonNode kmsRequest;
        try {
            kmsRequest = this.objectMapper.readTree(templateUrl);
        } catch (IOException e) {
            throw new IOException("File not found", e);
        }
        return kmsRequest;
    }
}