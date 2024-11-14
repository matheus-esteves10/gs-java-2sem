package br.com.fiap.dao.compra;

import br.com.fiap.config.DatabaseConnectionFactory;
import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public List<Produto> buscarValorProdutos(List<Long> idsProdutos) throws NotFoundException {
        List<Produto> valoresProduto = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmtValor = null;
        ResultSet rsValor = null;

        try {
            connection = DatabaseConnectionFactory.create().get();


            stmtValor = connection.prepareStatement("SELECT id_produto, valor_produto FROM t_sph_produtos WHERE id_produto = ?");

            for (Long idProduto : idsProdutos) {
                stmtValor.setLong(1, idProduto);
                rsValor = stmtValor.executeQuery();

                if (rsValor.next()) {
                    Produto produto = new Produto();
                    produto.setIdProduto(rsValor.getLong("id_produto"));
                    produto.setValorProduto(rsValor.getDouble("valor_produto"));

                    valoresProduto.add(produto);
                } else {
                    throw new NotFoundException();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produtos por compra", e);
        } finally {
            try {
                if (rsValor != null) rsValor.close();
                if (stmtValor != null) stmtValor.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return valoresProduto;
    }



}
