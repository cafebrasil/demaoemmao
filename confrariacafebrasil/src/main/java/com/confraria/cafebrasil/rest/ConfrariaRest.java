package com.confraria.cafebrasil.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.confraria.cafebrasil.logger.Log;
import com.confraria.cafebrasil.service.LivroService;
import com.confraria.cafebrasil.util.Resources;

@Path("/v1/demaoemmao")
public class ConfrariaRest {

	@Inject
	Log logger;

	@Inject
	private LivroService livroService;

	@GET
	@Produces(Resources.APPLICATION_JSON_UTF8)
	@Path(value = "/livros")
	public Response listarLivros() {
		logger.info("Recuperar livros Café Brasil");
		return Response.ok(livroService.listar()).build();
	}

}
