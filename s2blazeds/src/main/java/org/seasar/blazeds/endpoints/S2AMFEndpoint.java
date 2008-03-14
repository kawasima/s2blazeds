/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.blazeds.endpoints;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import flex.messaging.endpoints.AMFEndpoint;
import flex.messaging.messages.Message;
import flex.messaging.services.RemotingService;
import flex.messaging.services.remoting.RemotingDestination;

/**
 * Seasar2用のAMFEndpointです。
 * 
 * @author higa
 * 
 */
public class S2AMFEndpoint extends AMFEndpoint {

	/**
	 * コンストラクタです。
	 */
	public S2AMFEndpoint() {
	}

	/**
	 * コンストラクタです。
	 * 
	 * @param enableManagement
	 *            JMXによる管理を可能にするかどうか
	 */
	public S2AMFEndpoint(boolean enableManagement) {
		super(enableManagement);
	}

	public Message serviceMessage(Message message) {
		S2Container container = SingletonS2ContainerFactory.getContainer();
		if (container.hasComponentDef(message.getDestination())) {
			RemotingService remotingService = (RemotingService) getMessageBroker()
					.getService("remoting-service");
			synchronized (remotingService) {
				RemotingDestination destination = (RemotingDestination) remotingService
						.getDestination(message.getDestination());
				if (destination == null) {
					destination = (RemotingDestination) remotingService
							.createDestination(message.getDestination());
					destination.setChannels(remotingService
							.getDefaultChannels());
					destination.createAdapter(remotingService
							.getDefaultAdapter());
					remotingService.addDestination(destination);
				}

			}
		}
		return super.serviceMessage(message);
	}
}