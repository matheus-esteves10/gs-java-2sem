package br.com.fiap.dao.carrinho;

import br.com.fiap.model.Carrinho;

import java.sql.Connection;
import java.util.logging.Logger;

public class DaoCarrinhoImpl implements DaoCarrinho {

    private Connection connection;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public DaoCarrinhoImpl() {
    }

    public DaoCarrinhoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Carrinho save(Carrinho carrinho, Connection connection) {
        return null;
    }

    @Override
    public void remover(Long id, Connection connection) {

    }
}
