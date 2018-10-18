package org.litespring.context.support;

import org.litespring.beans.factory.suppory.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;

public class ClassPathXmlApplicationContext implements ApplicationContext {
	private DefaultBeanFactory factory=null;
	public ClassPathXmlApplicationContext(String configFile) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(configFile);;
	}

	public Object getBean(String beanId) {
		return factory.getBean(beanId);
	}

}
