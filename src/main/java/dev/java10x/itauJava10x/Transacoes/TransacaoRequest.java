package dev.java10x.itauJava10x.Transacoes;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class TransacaoRequest {

  @NotNull(message = "O valor da transacao ser obrigatorio.")
  @PositiveOrZero(message = "O valor da transacao deve ser igual ou maior que zero.")
  private BigDecimal valor;

  @NotNull(message = "A data e hora da transacao ser obrigatoria.")
  @PastOrPresent(message = "A data e hora deve ser no passado ou presente.")
  private OffsetDateTime dataHora;

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public OffsetDateTime getDataHora() {
    return dataHora;
  }

  public void setDataHora(OffsetDateTime dataHora) {
    this.dataHora = dataHora;
  }

}
