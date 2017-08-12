package com.confraria.cafebrasil.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.confraria.cafebrasil.entity.Tag;
import com.confraria.cafebrasil.exception.ConfrariaException;
import com.confraria.cafebrasil.logger.Log;

@Stateless
public class TagService {

	@EJB
	Service<Tag> service;

	@Inject
	Log logger;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Tag salvar(final Tag tag) throws ConfrariaException {
		try {
			service.update(tag);
			return tag;
		} catch (final Exception e) {
			logger.info(String.format("Rest /livros - %s", e.getMessage()));
			throw new ConfrariaException(e.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Tag recuperarPorDescricao(final Tag tag) throws ConfrariaException {
		try {
			return service.find(Tag.class, "Tag.recuperarPorDescricao", tag.getDescricao());

		} catch (final NoResultException e) {
			return null;
		}
	}

}
