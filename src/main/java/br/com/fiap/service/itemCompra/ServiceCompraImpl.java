package br.com.fiap.service.itemCompra;

import br.com.fiap.dao.compra.DaoCompra;
import br.com.fiap.dao.compra.DaoCompraFactory;
import br.com.fiap.model.CompraProduto;

import java.util.List;

public class ServiceCompraImpl implements ServiceCompra {

    private final DaoCompra dao = DaoCompraFactory.create();

    @Override
    public double calcularValorTotal(List<CompraProduto> compraProdutos) {
        double valorTotal = 0.0;

        for (CompraProduto compraProduto : compraProdutos) {
            double valorProduto = compraProduto.getProduto().getValorProduto();
            int quantidade = compraProduto.getQuantidade();
            valorTotal += valorProduto * quantidade;
        }

        return valorTotal;
    }
}
