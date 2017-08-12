package com.confraria.cafebrasil.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.confraria.cafebrasil.exception.ConfrariaException;
import com.confraria.cafebrasil.service.LivroTagService;
import com.confraria.cafebrasil.util.Resources;

@Path("/v1/demaoemmao/tag")
public class TagsRest {

	@Inject
	private LivroTagService livroTagService;

	@GET
	@Produces(Resources.APPLICATION_JSON_UTF8)
	@Path(value = "/listar/{codigoLivro}")
	public Response listarLivros(@PathParam("codigoLivro") final Long codigoLivro) {
		try {
			return Response
					.ok(livroTagService.recuperarTagsPorLivro(codigoLivro))
					.build();
		} catch (final ConfrariaException e) {
			return Response.noContent().build();
		}
	}
}
