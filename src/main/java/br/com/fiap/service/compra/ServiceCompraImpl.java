package br.com.fiap.service.compra;

import br.com.fiap.dao.compra.DaoCompra;
import br.com.fiap.dao.compra.DaoCompraFactory;
import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.model.CompraProduto;

import java.util.List;

public class ServiceCompraImpl implements ServiceCompra {

    private final DaoCompra dao = DaoCompraFactory.create();

    @Override
    public double calcularValorTotal(List<Long> idsProdutos) {

        List<CompraProduto> compraProdutos = null;
        try {
            compraProdutos = dao.buscarProdutosPorCompra(idsProdutos);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }


        double valorTotal = 0.0;

        for (CompraProduto compraProduto : compraProdutos) {
            double valorProduto = compraProduto.getProduto().getValorProduto();
            int quantidade = compraProduto.getQuantidade();
            valorTotal += valorProduto * quantidade;
        }

        return valorTotal;
    }
}
