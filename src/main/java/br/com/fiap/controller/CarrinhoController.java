package br.com.fiap.controller;

import br.com.fiap.dto.CarrinhoDto;
import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.exceptions.NotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.model.Carrinho;
import br.com.fiap.service.carrinho.ServiceCarrinho;
import br.com.fiap.service.carrinho.ServiceCarrinhoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/carrinho")
public class CarrinhoController {

    private final ServiceCarrinho serviceCarrinho = ServiceCarrinhoFactory.create();

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add (CarrinhoDto carrinhoDto) throws UnsupportedServiceOperationException{
        if(carrinhoDto.id() == null & carrinhoDto.isPago()){
            try{
                Carrinho carrinho = this.serviceCarrinho.adicionar(new Carrinho(carrinhoDto.nomeItem(), carrinhoDto.valor(), carrinhoDto.quantidade(), carrinhoDto.isPago()));
                return Response.status(Response.Status.CREATED).
                        entity(carrinho).build();
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
            this.serviceCarrinho.remover(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar deletar item da lista de comprados")).build();
        }
    }
}
