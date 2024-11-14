package br.com.fiap.service.compra;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.model.CompraProduto;

import java.util.List;

public interface ServiceCompra {

    double calcularValorTotal(List<CompraProduto> produtos) throws NotFoundException;
}
