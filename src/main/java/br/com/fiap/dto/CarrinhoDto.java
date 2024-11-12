package br.com.fiap.dto;

public record CarrinhoDto(Long id,
                          String nomeItem,
                          float valor,
                          Integer quantidade,
                          boolean isPago
                          ) {
}
