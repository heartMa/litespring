package org.litespring.beans.factory.suppory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.utils.ClassUtils;

public class DefaultBeanFactory implements BeanFactory,BeanDefinitionRegistry {

	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);
	public DefaultBeanFactory() {
		
	}
	
	public BeanDefinition getBeanDefinition(String beanId) {
		return this.beanDefinitionMap.get(beanId);
	}
	
	public void registerBeanDefinition(String beanID,BeanDefinition bd){
		this.beanDefinitionMap.put(beanID, bd);
	}
	
	public Object getBean(String beanId) {
		BeanDefinition bd = this.beanDefinitionMap.get(beanId);
		if(bd==null){
			throw new BeanCreationException("Bean Definition dose not exit");
		}
		ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
		String beanClassName = bd.getBeanClassName();
		try {
			Class<?> clz = classLoader.loadClass(beanClassName);
			return clz.newInstance();
		} catch (Exception e) {
			throw new BeanCreationException("Create Bean for "+beanClassName+" faild,",e);
		}
	}

}
