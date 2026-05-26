package dev.java10x.itauJava10x.Estatisticas;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.java10x.itauJava10x.Docs.EstatisticaControllerDoc;
import dev.java10x.itauJava10x.Transacoes.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController implements EstatisticaControllerDoc {

  @Autowired
  private EstatisticaProperties estatisticaProperties;

  @Autowired
  private TransacaoRepository transacaoRepository;

  @GetMapping
  public ResponseEntity estatistica() {

    // Log de requisicao criado via lombok
    log.info("Calculando estatisticas de transacoes");
    // Calcular quantas transacoes acontecem em N segundos
    final var horaInicial = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());
    return ResponseEntity.ok(transacaoRepository.estatisticaDTO(horaInicial));
  }
}
