package br.com.fiap.dao.compra;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.model.Produto;

import java.util.List;

public interface DaoCompra {

    List<Produto> buscarValorProdutos(List<Long> idsProdutos) throws NotFoundException;


}
