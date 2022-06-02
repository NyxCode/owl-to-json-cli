package com.nyxcode.owntojson.cli;

import com.github.arhs.owl2json.Owl2Json;
import com.github.arhs.owl2json.model.json.JsonSchemaObject;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    System.err.println("args: " + Arrays.toString(args));
    if (args.length < 3) {
      System.err.println("not enough args");
      System.exit(1);
      return;
    }
    Owl2Json owl2Json = new Owl2Json(args[0], args[1]);
    List<String> types = Arrays.stream(args).skip(2).toList();
    JsonSchemaObject json = owl2Json.generateTemplate(types);
    // TODO: somehow print the json
  }
}