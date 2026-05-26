package dev.java10x.itauJava10x.Transacoes;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dev.java10x.itauJava10x.Estatisticas.EstatisticaDTO;

@Repository
public class TransacaoRepository {

  List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

  // salvar os dados em uma lista
  public void salvarDados(TransacaoRequest transacaoRequest) {
    listaDeTransacoes.add(transacaoRequest);
  }

  // APAGAR ESSA LISTA DEPOIS DE 60 SEGUNDOS
  public void limparDados(TransacaoRequest transacaoRequest) {
  }

  // APAGAR TODAS AS TRANSACOES DA LISTA }
  public void deletarDados() {
    listaDeTransacoes.clear();
  }

  // Gerar Estatistica
  public EstatisticaDTO estatisticaDTO(OffsetDateTime horaInicial) {

    if (listaDeTransacoes.isEmpty()) {
      return new EstatisticaDTO(0, 0.0, 0.0, 0.0, 0.0);
    }

    // Trnasformar a lista de transacoes em numeros para fazer uma operacao
    final var summary = listaDeTransacoes.stream()
        .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial))// Filtrar transacoes
                                                                                                  // que sejam depois ou
                                                                                                  // igual a hora
                                                                                                  // inicial
        .mapToDouble(t -> t.getValor().doubleValue())// Tranformar o BigDecimal em double para melhor manipulacao em
                                                     // operacoes matematicas
        .summaryStatistics();// Gerar as estatisticas da stream, como count, average, max, min e sum

    return new EstatisticaDTO(
        summary.getCount(),
        summary.getAverage(),
        summary.getMax(),
        summary.getMin(),
        summary.getSum());
  }
}
