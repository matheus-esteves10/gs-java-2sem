package br.com.fiap.service.itemCompra;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.model.Compra;

import java.sql.SQLException;

public interface ServiceCompra {

    Compra adicionar(Compra compra) throws UnsupportedServiceOperationException, SQLException, NotSavedException;

    void remover(Long id) throws NotFoundException, SQLException;
}
