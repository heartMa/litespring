package org.litespring.beans.factory;

import org.litespring.beans.BeansException;


public class BeanDefinitionStoreException extends BeansException {
	
	private static final long serialVersionUID = 1L;

	public BeanDefinitionStoreException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
