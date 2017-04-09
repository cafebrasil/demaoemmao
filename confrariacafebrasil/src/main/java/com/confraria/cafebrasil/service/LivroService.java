package com.confraria.cafebrasil.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.confraria.cafebrasil.entity.Livro;
import com.confraria.cafebrasil.exception.ConfrariaException;
import com.confraria.cafebrasil.logger.Log;


/**
 * Session Bean implementation class Livros
 */
@Stateless
public class LivroService {

	@EJB Service<Livro> service;

	@Inject Log logger;

	public LivroService() {
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Livro> listar() throws ConfrariaException {
		try {
			return service.findAll("Livro.listaTodos", Livro.class);
		}catch (final Exception e) {
			logger.info(String.format("Rest /livros - %s", e.getMessage()));
			throw new ConfrariaException(e.getMessage());
		}
	}
}
