package dev.java10x.itauJava10x.Transacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.java10x.itauJava10x.Docs.TransacaoControllerDoc;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController implements TransacaoControllerDoc {

  @Autowired
  private TransacaoService transacaoService;

  @Autowired
  private TransacaoRepository transacaoRepository;

  @PostMapping
  public ResponseEntity adicionar(@Valid @RequestBody TransacaoRequest transacaoRequest) {
    log.info("Enviando requisição de transação: {}", transacaoRequest);
    try {
      transacaoService.validarTransacao(transacaoRequest);
      transacaoRepository.salvarDados(transacaoRequest);
      return ResponseEntity.status(HttpStatus.CREATED).build();

    } catch (IllegalArgumentException exception) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

  }

  @DeleteMapping
  public ResponseEntity deletar() {
    transacaoRepository.deletarDados();
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
