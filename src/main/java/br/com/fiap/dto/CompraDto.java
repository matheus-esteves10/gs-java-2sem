package br.com.fiap.dto;

public record CompraDto(Long idCompra,
                        Double valorCompra,
                        boolean isPago,
                        Long idUsuario
                          ) {
}
