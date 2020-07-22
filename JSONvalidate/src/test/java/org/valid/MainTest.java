/*
 * Copyright (c) 2008-2020
 * Sberbank
 * All rights reserved.
 *
 * This product and related documentation are protected by copyright and
 * distributed under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * Sberbank and its licensors, if any.
 *
 * $
 */
package org.valid;

import org.apache.commons.io.IOUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Project: java-big-decimal
 *
 * <p>Author: Galkin
 *
 * <p>Date: 16.07.2020
 *
 * <p>Time: 12:29 Descriptions
 */
public class MainTest {
  public static final Charset CHARSET = StandardCharsets.UTF_8;
  @Test
  public void test1() {
    try {
      // InputStream inputStream = getClass().getResourceAsStream(fileName("myJsonSchema.json"));
      InputStream inputStream =  new ByteArrayInputStream(
        ("{\n"
              + "\t \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n"
              + "\t \"description\": \"Comment describing your JSON Schema\",\n"
              + "\t \"type\": \"object\",\n"
              + "\t \"properties\": {\n"
              + "\t\t \"typeType\": {\n"
              + "\t\t\t \"type\": \"string\"\n"
              + "\t\t},\n"
              + "\t\t \"name\": {\n"
              + "\t\t\t \"type\": \"string\"\n"
              + "\t\t}\n"
              + "\t},\n"
              + "\t \"additionalProperties\": false\n"
              + "}").getBytes());
      if (inputStream == null) System.out.println("not found " + fileName("myJsonSchema.json"));
      //System.out.println(file("myJsonSchema.json"));
      JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
      Schema schema = SchemaLoader.load(rawSchema);
      schema.validate(
          new JSONObject(
              "{\"hello\" : \"world\", \"hello1\" : \"world\"}")); // throws a ValidationException if
                                                                  // this object is invalid
    } catch (NullPointerException e) {
      e.printStackTrace();
    } catch (ValidationException e) {
      System.out.println(e.getMessage());
      e.getCausingExceptions().stream()
          .map(ValidationException::getMessage)
          .forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String fileName(String fileName) {
    return fileName.startsWith("/") ? fileName : "/" + getClass().getName().replace(".", "/") + "/" + fileName;
  }

  public String file(String fileName) {
          String resourceName = fileName.startsWith("/") ? fileName : "/" + getClass().getName().replace(".", "/") + "/" + fileName;
          try (InputStream inputStream = getClass().getResourceAsStream(resourceName)) {
              if (inputStream == null) {
                  throw new IOException(String.format("Resource %s not found", resourceName));
              } else {
                  return IOUtils.toString(inputStream, CHARSET);
              }
          } catch (IOException e) {
              throw new IllegalArgumentException("Error reading " + fileName, e);
          }
      }
}
