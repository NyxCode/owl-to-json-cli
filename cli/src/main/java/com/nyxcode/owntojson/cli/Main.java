package com.nyxcode.owntojson.cli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.arhs.owl2json.Owl2Json;
import com.github.arhs.owl2json.model.json.JsonSchemaObject;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    if (args.length < 3) {
      System.err.println("not enough args");
      System.exit(1);
      return;
    }
    String policy = args[0];
    String ontology = args[1];
    List<String> types = Arrays.stream(args).skip(2).toList();
    System.err.println("policy = " + policy);
    System.err.println("ontology = " + ontology);
    System.err.println("types = " + types);

    Owl2Json owl2Json = new Owl2Json(policy, ontology);
    JsonSchemaObject json = owl2Json.generateTemplate(types);
    System.out.println(prettify(json));
  }

  private static String prettify(final JsonSchemaObject json) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    return mapper.writeValueAsString(json);
  }
}