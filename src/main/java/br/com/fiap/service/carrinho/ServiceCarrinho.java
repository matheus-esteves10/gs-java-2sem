package br.com.fiap.service.carrinho;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.model.Carrinho;

import java.sql.SQLException;

public interface ServiceCarrinho {

    Carrinho adicionar(Carrinho carrinho) throws UnsupportedServiceOperationException, SQLException, NotSavedException;

    void remover(Long id) throws NotFoundException, SQLException;
}
