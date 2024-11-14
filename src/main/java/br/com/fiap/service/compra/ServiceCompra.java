package br.com.fiap.service.compra;

import br.com.fiap.exceptions.NotFoundException;

import java.util.List;

public interface ServiceCompra {

    double calcularValorTotal(List<Long> idsProdutos) throws NotFoundException;
}
