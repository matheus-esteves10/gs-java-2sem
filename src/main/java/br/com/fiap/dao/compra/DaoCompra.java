package br.com.fiap.dao.compra;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.model.Compra;
import br.com.fiap.model.CompraProduto;

import java.sql.Connection;
import java.util.List;

public interface DaoCompra {

    List<CompraProduto> buscarProdutosPorCompra(List<Long> idsProdutos) throws NotFoundException;


}
