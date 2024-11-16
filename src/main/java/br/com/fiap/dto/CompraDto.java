package br.com.fiap.dto;

import java.time.LocalDate;

public record CompraDto(Long idCompra,
                        Double valorCompra,
                        Boolean isPago,
                        Long idUsuario,
                        int quantidadeParcelas,
                        LocalDate dataCompra
                        ) {
}
