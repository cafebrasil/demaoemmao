package com.confraria.cafebrasil.logger;

import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;

@Alternative
public class DevNulllogger implements Log {

	@Override
	public void info(String log) {
		
	}

	@Override
	public Logger getLogger() {
		return null;
	}

	
}
