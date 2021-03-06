package org.litespring.context.support;

import org.litespring.beans.factory.suppory.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.ClassPathResource;

public class ClassPathXmlApplicationContext implements ApplicationContext {
	private DefaultBeanFactory factory=null;
	public ClassPathXmlApplicationContext(String configFile) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		ClassPathResource resource = new ClassPathResource(configFile);
		reader.loadBeanDefinitions(resource);;
	}

	public Object getBean(String beanId) {
		return factory.getBean(beanId);
	}

}
