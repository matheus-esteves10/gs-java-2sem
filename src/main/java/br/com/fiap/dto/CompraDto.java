package br.com.fiap.dto;

public record CompraDto(Long idCompra,
                        Double valorCompra,
                        Boolean isPago,
                        Long idUsuario,
                        int quantidadeParcelas
                          ) {
}
