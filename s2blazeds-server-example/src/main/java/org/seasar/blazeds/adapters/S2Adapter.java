package org.seasar.blazeds.adapters;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import flex.messaging.FactoryInstance;
import flex.messaging.services.remoting.RemotingDestination;
import flex.messaging.services.remoting.adapters.JavaAdapter;

/**
 * Seasar2用のアダブタです。
 * 
 * @author higa
 * 
 */
public class S2Adapter extends JavaAdapter {

	protected Object createInstance(Class cl) {
		RemotingDestination remotingDestination = (RemotingDestination) getDestination();
		FactoryInstance factoryInstance = remotingDestination
				.getFactoryInstance();
		S2Container container = SingletonS2ContainerFactory.getContainer();
		if (container.hasComponentDef(factoryInstance.getId())) {
			return container.getComponent(factoryInstance.getId());
		}
		return super.createInstance(cl);
	}

}
