package br.com.fiap.service.carrinho;

import br.com.fiap.config.DatabaseConnectionFactory;
import br.com.fiap.dao.carrinho.DaoCarrinho;
import br.com.fiap.dao.carrinho.DaoCarrinhoFactory;
import br.com.fiap.exceptions.NotFoundException;

import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.model.Carrinho;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceCarrinhoImpl implements ServiceCarrinho {

    private final DaoCarrinho dao = DaoCarrinhoFactory.create();
    @Override
    public Carrinho adicionar(Carrinho carrinho) throws UnsupportedServiceOperationException, SQLException, NotSavedException {
        if(carrinho.isPago() && carrinho.getId() == null) {
            Connection connection = DatabaseConnectionFactory.create().get();
            try{
                carrinho = this.dao.save(carrinho, connection);
                connection.commit();
                return carrinho;
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        } else {
            throw new UnsupportedServiceOperationException();
        }
    }

    @Override
    public void remover(Long id) throws NotFoundException, SQLException {
        Connection connection = DatabaseConnectionFactory.create().get();
        this.dao.remover(id, connection);
        connection.commit();
    }
}
