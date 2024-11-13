package br.com.fiap.service.itemCompra;

import br.com.fiap.config.DatabaseConnectionFactory;
import br.com.fiap.dao.compra.DaoCompra;
import br.com.fiap.dao.compra.DaoCompraFactory;
import br.com.fiap.exceptions.NotFoundException;

import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.model.Compra;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceCompraImpl implements ServiceCompra {

    private final DaoCompra dao = DaoCompraFactory.create();
    @Override
    public Compra adicionar(Compra compra) throws UnsupportedServiceOperationException, SQLException, NotSavedException {
        if(compra.isPago() && compra.getIdCompra() == null) {
            Connection connection = DatabaseConnectionFactory.create().get();
            try{
                compra = this.dao.save(compra, connection);
                connection.commit();
                return compra;
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
