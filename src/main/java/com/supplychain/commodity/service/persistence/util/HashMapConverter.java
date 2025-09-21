package com.supplychain.commodity.service.persistence.util;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashMapConverter.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> mapModel) {

	String mapJson = null;
	try {
	    mapJson = objectMapper.writeValueAsString(mapModel);
	} catch (final JsonProcessingException e) {
	    LOGGER.error("JSON writing error", e);
	}

	return mapJson;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> convertToEntityAttribute(String mapJSON) {

	Map<String, Object> mapModel = null;
	try {
	    mapModel = objectMapper.readValue(mapJSON, Map.class);
	} catch (final IOException e) {
	    LOGGER.error("JSON reading error", e);
	}

	return mapModel;
    }
}