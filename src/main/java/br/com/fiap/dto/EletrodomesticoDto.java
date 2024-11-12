package br.com.fiap.dto;

public record EletrodomesticoDto(Long id,
                                 String categoria,
                                 float consumoKwH,
                                 float tempoConsumo,
                                 int quantidadeDiasLigado) {
}
