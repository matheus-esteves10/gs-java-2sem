package br.com.fiap.dao.carrinho;

import br.com.fiap.model.Carrinho;

import java.sql.Connection;

public interface DaoCarrinho {

    Carrinho save(Carrinho carrinho, Connection connection);

    void remover(Long id, Connection connection);


}
