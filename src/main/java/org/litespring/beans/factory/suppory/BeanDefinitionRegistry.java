package org.litespring.beans.factory.suppory;

import org.litespring.beans.BeanDefinition;



public interface BeanDefinitionRegistry {
	BeanDefinition getBeanDefinition(String beanID);
	void registerBeanDefinition(String beanID, BeanDefinition bd);
}
