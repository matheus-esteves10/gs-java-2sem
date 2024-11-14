package br.com.fiap.service.itemCompra;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.model.Compra;
import br.com.fiap.model.CompraProduto;

import java.sql.SQLException;
import java.util.List;

public interface ServiceCompra {

    double calcularValorTotal(List<CompraProduto> compraProdutos);
}
