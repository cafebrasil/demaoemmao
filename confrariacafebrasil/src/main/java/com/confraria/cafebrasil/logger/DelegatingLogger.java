package com.confraria.cafebrasil.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author mederafael
 *
 */
public class DelegatingLogger implements Log {

	private Logger logger;

	/**
	 * @param logger
	 */
	public DelegatingLogger(Logger logger) {
		super();
		this.logger = logger;
	}

	public void log(final Level level, final String mensagem, final Object[] params) {
		logger.log(level, mensagem, params);
	}

	@Override
	public void info(final String mensagem) {
		logger.log(Level.INFO, mensagem, new Object[] {});
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

}
