package br.com.fiap.controller;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.model.CompraProduto;
import br.com.fiap.model.Produto;
import br.com.fiap.service.compra.ServiceCompra;
import br.com.fiap.service.compra.ServiceCompraFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/compra")
public class CompraController {

    private final ServiceCompra compraService = ServiceCompraFactory.create();

    @POST
    @Path("/total")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response calcularValorTotal(List<CompraProduto> produtos) {
        try {

            double valorTotal = compraService.calcularValorTotal(produtos);

            // Retorna o valor total em formato JSON
            return Response.ok().entity("{\"valorTotal\": " + valorTotal + "}").build();

        } catch (NotFoundException e) {
            // Retorna um erro caso algum produto não seja encontrado
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Produto não encontrado - " + e.getMessage() + "\"}")
                    .build();
        } catch (Exception e) {
            // Retorna um erro interno caso ocorra algum problema não esperado
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Erro interno: " + e.getMessage() + "\"}")
                    .build();
        }
    }


}
