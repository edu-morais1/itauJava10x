package dev.java10x.itauJava10x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ItauJava10xApplication {

  public static void main(String[] args) {
    SpringApplication.run(ItauJava10xApplication.class, args);
  }

}
