package dev.java10x.itauJava10x.Transacoes;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

  public void validarTransacao(TransacaoRequest transacaoRequest) {
    // E importante que a validacao null seja feita antes da validacao de valor
    // negativo, para evitar NullPointerException
    if (transacaoRequest.getValor() == null) {
      throw new IllegalArgumentException("Erro: Body vazio");
    }
    if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException(
          "Erro: Isso nao é uma transacao válida, transações devem ter valor maior do que zero");

    }
    if (transacaoRequest.getDataHora() == null) {
      throw new IllegalArgumentException("Erro: Body vazio");
    }
    if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
      throw new IllegalArgumentException("Erro: Na data da transacao");

    }
  }
}
