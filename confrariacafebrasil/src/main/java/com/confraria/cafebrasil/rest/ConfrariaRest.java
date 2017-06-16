package com.confraria.cafebrasil.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.confraria.cafebrasil.exception.ConfrariaException;
import com.confraria.cafebrasil.service.LivroService;
import com.confraria.cafebrasil.util.Resources;

@Path("/v1/demaoemmao/livros")
public class ConfrariaRest {

	@Inject
	private LivroService livroService;

	@GET
	@Produces(Resources.APPLICATION_JSON_UTF8)
	@Path(value = "/listar")
	public Response listarLivros() {
		try {
			return Response
					.ok(livroService.listar())
				    .build();
		} catch (final ConfrariaException e) {
			return Response.noContent().build();
		}
	}

	@POST
	@Produces(Resources.APPLICATION_JSON_UTF8)
	@Path(value = "/pesquisar")
	public Response pesquisarLivros(final String descricao) {
		try {
			return Response.ok(livroService.pesquisar(descricao)).build();
		} catch (final ConfrariaException e) {
			return Response.noContent(
					).build();
		}
	}
}
