package com.confraria.cafebrasil.logger;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

public class LogProduces {

	@Inject
	boolean debug;

	@Produces
	public Log getLogger(final InjectionPoint point) {
		if (debug) {
			return new DelegatingLogger(Logger.getLogger(point.getMember().getDeclaringClass().getName()));
		}
		return new DevNulllogger();
	}

}
