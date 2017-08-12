package com.confraria.cafebrasil.service;

import javax.ejb.EJB;
import javax.inject.Inject;

import com.confraria.cafebrasil.entity.Autor;
import com.confraria.cafebrasil.logger.Log;

public class AutorService {
	@EJB Service<Autor> service;
	@Inject Log logger;

}
