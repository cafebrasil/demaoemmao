package com.confraria.cafebrasil.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.confraria.cafebrasil.entity.LivroTag;
import com.confraria.cafebrasil.exception.ConfrariaException;
import com.confraria.cafebrasil.logger.Log;

@Stateless
public class LivroTagService {

	@EJB Service<LivroTag> service;

	@Inject Log logger;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<LivroTag> recuperarTagsPorLivro(final Long codigoLivro) throws ConfrariaException {
		try {
			return service.findAllByParams(LivroTag.class, "LivroTag.findByCodigoLivro", codigoLivro);
		}catch (final Exception e) {
			logger.info(String.format("Rest /livros - %s", e.getMessage()));
			throw new ConfrariaException(e.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(final Long codigo) throws ConfrariaException {
		try {
			service.delete(LivroTag.class, codigo);
		}catch (final Exception e) {
			logger.info(String.format("Rest /livros - %s", e.getMessage()));
			throw new ConfrariaException(e.getMessage());
		}
	}
}