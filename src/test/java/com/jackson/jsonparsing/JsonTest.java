package com.jackson.jsonparsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.jackson.jsonparsing.pojo.SimpleTestCaseJsonPOJO;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private String simpleTestCaseJsonSource = "{ \"title\" : \"test\", \"author\" : \"will\" }";

    @org.junit.jupiter.api.Test
    void parse() throws IOException {
        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(), "test");
    }

    @org.junit.jupiter.api.Test
    void fromJson() throws IOException {
        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPOJO pojo = Json.fromJson(node, SimpleTestCaseJsonPOJO.class);
        assertEquals(pojo.getTitle(), "test");
    }

    @org.junit.jupiter.api.Test
    void toJson() {
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        pojo.setTitle("Testing123");
        JsonNode node = Json.toJson(pojo);
        assertEquals(node.get("title").asText(), "Testing123");
    }
}
