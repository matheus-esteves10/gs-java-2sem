package br.com.fiap.dao.compra;

import br.com.fiap.config.DatabaseConnectionFactory;
import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.model.Compra;
import br.com.fiap.model.Produto;

import java.sql.*;
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

    @Override
    public Compra save(Compra compra, Connection connection) throws SQLException, NotSavedException {
        final String sql = "Begin INSERT INTO t_sph_compra (valor_compra, is_pago, id_usuario, quant_parcelas) VALUES (?, ?, ?, ?) RETURNING ID_COMPRA INTO ?; END;";
        CallableStatement callableStatement = connection.prepareCall(sql);
        callableStatement.setDouble(1, compra.getValorCompra());
        callableStatement.setBoolean(2, compra.getPago());
        callableStatement.setLong(3, compra.getIdUsuario());
        callableStatement.setInt(4, compra.getNumeroParcelas());
        callableStatement.registerOutParameter(5, Types.NUMERIC);
        callableStatement.execute();
        long id = callableStatement.getInt(5);
        if (id == 0) {
            throw new NotSavedException();
        }
        compra.setIdCompra(id);
        return compra;
    }


}
