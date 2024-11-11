package br.com.fiap.dao.usuario;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DaoUsuarioImpl implements DaoUsuario {

    private Connection connection;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public DaoUsuarioImpl() {
    }

    public DaoUsuarioImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Usuario save(Usuario usuario, Connection connection) throws SQLException, NotSavedException {
        return null;
    }

    @Override
    public Usuario update(Usuario usuario, Connection connection) throws SQLException, NotFoundException {
        return null;
    }

    @Override
    public void deleteById(Long id, Connection connection) throws SQLException, NotFoundException {

    }
}
