package br.com.fiap.controller;

import br.com.fiap.dto.CompraDto;
import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.model.Compra;
import br.com.fiap.service.itemCompra.ServiceCompra;
import br.com.fiap.service.itemCompra.ServiceCompraFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/carrinho")
public class CompraController {

    private final ServiceCompra serviceCompra = ServiceCompraFactory.create();

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add (CompraDto compraDto) throws UnsupportedServiceOperationException{
        if(compraDto.idCompra() == null & compraDto.isPago()){
            try{
                Compra compra = this.serviceCompra.adicionar(new Compra(null, compraDto.valorCompra(), compraDto.isPago(), compraDto.idUsuario()));
                return Response.status(Response.Status.CREATED).
                        entity(compra).build();
            } catch (SQLException | NotSavedException e){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(Map.of("mensagem","erro inesperado ao tentar inserir item na lista de comprados: " + e)).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(
                            Map.of(
                                    "mensagem",
                                    "esse método só permite adicionar novos itens na lista de comprados"))
                    .build();
    }
}




    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            this.serviceCompra.remover(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar deletar item da lista de comprados")).build();
        }
    }
}
