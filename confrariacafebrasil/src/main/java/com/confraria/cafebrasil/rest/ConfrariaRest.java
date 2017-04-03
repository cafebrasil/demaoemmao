package com.confraria.cafebrasil.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.confraria.cafebrasil.service.LivroService;

@Path("/v1/demaoemmao")
public class ConfrariaRest {
	
	@Inject
	private LivroService livroService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/livros")
	public Response teste(){
		return Response.ok(livroService.listar()).build();
	}

}
