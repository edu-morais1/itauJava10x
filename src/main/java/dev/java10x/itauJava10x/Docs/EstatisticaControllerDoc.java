package dev.java10x.itauJava10x.Docs;

import org.springframework.http.ResponseEntity;

import dev.java10x.itauJava10x.Estatisticas.EstatisticaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Estatisticas", description = "Endpoints de consulta de estatisticas")
public interface EstatisticaControllerDoc {

  @Operation(summary = "Obtém estatísticas", description = "Retorna estatísticas das transações dos últimos N segundos")
  @ApiResponse(responseCode = "200", description = "Estatísticas retornadas com sucesso")
  @ApiResponse(responseCode = "400", description = "Erro inesperado no servidor")
  ResponseEntity<EstatisticaDTO> estatistica();

}
