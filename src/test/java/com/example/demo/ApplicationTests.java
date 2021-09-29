package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collections;
import java.util.stream.Collectors;

@SpringBootTest
class ApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test 
 

  public void whenAssertingEquality_thenEqual() {
    String expected = "Baeldung";
    String actual = "Baeldung";

    
    assertEquals(expected, actual);
    System.out.println("========hoge");
    System.out.println(Stream.of("a,b,c".split(",")).collect(Collectors.toSet()));
    }
}
