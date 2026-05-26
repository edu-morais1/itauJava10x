package dev.java10x.itauJava10x.Config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {

  public OpenAPI apiInfo() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Desafio ITAU + Java10X")
                .description("Api desafio tecnico do ITAU + Java10X")
                .version("1.0.0"));
  }

}
