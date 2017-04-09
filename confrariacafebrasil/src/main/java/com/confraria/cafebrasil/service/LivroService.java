package com.confraria.cafebrasil.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.confraria.cafebrasil.entity.Livro;


/**
 * Session Bean implementation class Livros
 */
@Stateless(mappedName = "livros")
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class LivroService {

	@Inject
	EntityManager em;

	public LivroService() {
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Livro> listar() {
		return em.createNamedQuery("Livro.listarTodos", Livro.class).getResultList();
	}

}
