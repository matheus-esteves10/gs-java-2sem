package br.com.fiap.controller;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.service.eletrodomestico.ServiceEletrodomestico;
import br.com.fiap.service.eletrodomestico.ServiceEletrodomesticoFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/eletrodomestico")
public class EletrodomesticoController {

    private final ServiceEletrodomestico serviceEletrodomestico = ServiceEletrodomesticoFactory.create();

    @GET
    @Path("{classificacao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByNome(@PathParam("classificacao") String classificacao) {
        try {
            return Response.status(Response.Status.OK).
                    entity(this.serviceEletrodomestico.findByNome(classificacao)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
