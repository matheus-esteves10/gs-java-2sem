package br.com.fiap.dao.compra;

import br.com.fiap.model.Compra;

import java.sql.Connection;

public interface DaoCompra {

    Compra save(Compra compra, Connection connection);

    void remover(Long id, Connection connection);


}
