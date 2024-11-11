package br.com.fiap.dao.eletrodomestico;

import br.com.fiap.model.Eletrodomestico;

import java.sql.Connection;
import java.util.logging.Logger;

public class DaoEletrodomesticoImpl implements DaoEletrodomestico {

    private Connection connection;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public DaoEletrodomesticoImpl() {
    }

    public DaoEletrodomesticoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Eletrodomestico readByNome(String classificacao) {
        return null;
    }
}
