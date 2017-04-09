package com.confraria.cafebrasil.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {

    @Produces
	@PersistenceContext(unitName = "CafeBrasilPU")
    private EntityManager em;

    @Produces
	public final static boolean debug = Boolean.TRUE;

}
