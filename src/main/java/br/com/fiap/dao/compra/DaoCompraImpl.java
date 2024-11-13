package br.com.fiap.dao.compra;

import br.com.fiap.model.Compra;

import java.sql.Connection;
import java.util.logging.Logger;

public class DaoCompraImpl implements DaoCompra {

    private Connection connection;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public DaoCompraImpl() {
    }

    public DaoCompraImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Compra save(Compra compra, Connection connection) {
        return null;
    }

    @Override
    public void remover(Long id, Connection connection) {

    }
}
