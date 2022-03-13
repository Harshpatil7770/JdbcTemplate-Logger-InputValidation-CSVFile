package com.ecart.dao.logger;

import java.util.logging.Logger;

public class LoggerImpl {

	public static Logger getLogger(Class className) {
		return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
	}
}
