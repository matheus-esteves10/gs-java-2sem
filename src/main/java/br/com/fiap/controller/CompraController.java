package br.com.fiap.controller;

import br.com.fiap.dao.compra.DaoCompraFactory;
import br.com.fiap.dao.compra.DaoCompraImpl;
import br.com.fiap.dto.CompraDto;
import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.model.Compra;
import br.com.fiap.model.CompraProduto;
import br.com.fiap.service.itemCompra.ServiceCompra;
import br.com.fiap.service.itemCompra.ServiceCompraFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Path("/compra")
public class CompraController {

    private final ServiceCompra compraService = ServiceCompraFactory.create();
    private final DaoCompraImpl compraProdutoDao = (DaoCompraImpl) DaoCompraFactory.create();

    // Endpoint para calcular o valor total da compra
    @POST
    @Path("/calcularValorTotal")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response calcularValorTotal(List<Long> idsProdutos) {
        try {
            List<CompraProduto> compraProdutos = compraProdutoDao.buscarProdutosPorCompra(idsProdutos);


            double valorTotal = compraService.calcularValorTotal(compraProdutos);

            return Response.ok().entity("{\"valorTotal\": " + valorTotal + "}").build();
        } catch (NotFoundException e) {
            // Caso algum produto não seja encontrado
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Produto não encontrado - " + e.getMessage() + "\"}")
                    .build();
        } catch (Exception e) {
            // Caso ocorra algum erro no processamento
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Erro interno: " + e.getMessage() + "\"}")
                    .build();
        }
    }
}
