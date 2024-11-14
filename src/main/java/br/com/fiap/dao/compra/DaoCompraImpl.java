package br.com.fiap.dao.compra;

import br.com.fiap.config.DatabaseConnectionFactory;
import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.model.Compra;
import br.com.fiap.model.CompraProduto;
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
    public List<CompraProduto> buscarProdutosPorCompra(List<Long> idsProdutos) throws NotFoundException {
        List<CompraProduto> compraProdutos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmtValor = null;
        PreparedStatement stmtQuant = null;
        ResultSet rsValor = null;
        ResultSet rsQuant = null;

        try {
            connection = DatabaseConnectionFactory.create().get();

            //consultas SQL para pegar o valor e quantidade
            stmtValor = connection.prepareStatement("SELECT valor_produto FROM t_sph_produtos WHERE id_produto = ?");
            stmtQuant = connection.prepareStatement("SELECT quantidade FROM t_sph_compra_produto WHERE t_sph_produtos_id_produto = ?");


            for (Long idProduto : idsProdutos) { //valor e quantidade de cada id
                stmtValor.setLong(1, idProduto);
                rsValor = stmtValor.executeQuery();

                stmtQuant.setLong(1, idProduto);
                rsQuant = stmtQuant.executeQuery();

                if (rsValor.next() && rsQuant.next()) {
                    //atribuindo os valores a coluna do database
                    CompraProduto compraProduto = new CompraProduto();
                    Produto produto = new Produto();
                    produto.setValorProduto(rsValor.getDouble("valor_produto"));
                    compraProduto.setProduto(produto);
                    compraProduto.setQuantidade(rsQuant.getInt("quantidade"));

                    compraProdutos.add(compraProduto);
                } else {
                    throw new NotFoundException();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produtos por compra", e);
        } finally {
            try {
                if (rsValor != null) rsValor.close();
                if (rsQuant != null) rsQuant.close();
                if (stmtValor != null) stmtValor.close();
                if (stmtQuant != null) stmtQuant.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return compraProdutos;
    }

}
