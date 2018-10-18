package org.litespring.context.support;

import org.litespring.beans.factory.suppory.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.FileSystemResource;

public class FileSystemXmlApplicationContext implements ApplicationContext {

	private DefaultBeanFactory factory=null;
	public FileSystemXmlApplicationContext(String configFile) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		FileSystemResource resource = new FileSystemResource(configFile);
		reader.loadBeanDefinitions(resource);
	}

	public Object getBean(String beanId) {
		return factory.getBean(beanId);
	}	

}
