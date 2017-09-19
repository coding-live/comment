package org.imooc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseService {

	protected final Logger logger;

	public BaseService() {
		this.logger = LoggerFactory.getLogger(super.getClass());
	}
}
