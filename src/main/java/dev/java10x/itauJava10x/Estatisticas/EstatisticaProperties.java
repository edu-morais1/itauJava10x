package dev.java10x.itauJava10x.Estatisticas;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(
    // Nao pode ser nulo ou negativo.
    @NotNull @Positive Integer segundos) {

}
