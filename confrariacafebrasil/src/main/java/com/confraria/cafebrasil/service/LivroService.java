package com.confraria.cafebrasil.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.confraria.cafebrasil.entity.Livro;
import com.confraria.cafebrasil.entity.LivroTag;
import com.confraria.cafebrasil.entity.Tag;
import com.confraria.cafebrasil.enums.SituacaoEnum;
import com.confraria.cafebrasil.exception.ConfrariaException;
import com.confraria.cafebrasil.logger.Log;


/**
 * Session Bean implementation class Livros
 */
@Stateless
public class LivroService {

	@EJB Service<Livro> service;

	@Inject Log logger;

	@EJB TagService tagService;
	@EJB LivroTagService livroTagService;

	public LivroService() {
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Livro salvar(final Livro livro) throws ConfrariaException {
		try {
			livroTagService.remover(livro.getCodigo());
			for (final LivroTag livroTag : livro.getLivroTags()) {
				livroTag.setCodigo(null);
				if(livroTag.getTag().getCodigo() == null) {
					if(tagService.recuperarPorDescricao(livroTag.getTag()) == null) {
						final Tag salvar = tagService.salvar(livroTag.getTag());
						System.out.println(salvar.getCodigo());
						livroTag.getTag().setCodigo(salvar.getCodigo());
					}
				}
			}
			return service.update(livro);
		}catch (final Exception e) {
			logger.info(String.format("Rest /livros - %s", e.getMessage()));
			throw new ConfrariaException(e.getMessage());
		}
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Integer contarQuantidadeLivros(final SituacaoEnum situacao) throws ConfrariaException {
		try {
			return service.em
					.createNamedQuery("Livro.contarQuantidadeLivros", Integer.class)
					.getSingleResult();
		}catch (final Exception e) {
			logger.info(String.format("Rest /livros - %s", e.getMessage()));
			throw new ConfrariaException(e.getMessage());
		}
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Livro> listar() throws ConfrariaException {
		try {
			return service.findAll("Livro.listarTodos", Livro.class);
		}catch (final Exception e) {
			logger.info(String.format("Rest /livros - %s", e.getMessage()));
			throw new ConfrariaException(e.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Livro> pesquisar(final String descricao) throws ConfrariaException {
		try {
			return service.find(String.format("%%%s%%", descricao),"Livro.pesquisar", Livro.class);
		}catch (final Exception e) {
			logger.info(String.format("Rest /livros - %s", e.getMessage()));
			throw new ConfrariaException(e.getMessage());
		}
	}
}
