package com.confraria.cafebrasil.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.core.MediaType;

public class Resources {

    @Produces
	@PersistenceContext(unitName = "CafeBrasilPU", type=PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Produces
	public final static boolean debug = Boolean.TRUE;

    @Produces @ApplicationScoped
    public final static String APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON +";"+ MediaType.CHARSET_PARAMETER + "=utf-8";

}
