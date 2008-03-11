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
package org.seasar.blazeds.adapters;

import org.seasar.blazeds.factories.S2Factory;

import flex.messaging.Destination;
import flex.messaging.services.remoting.RemotingDestination;
import flex.messaging.services.remoting.adapters.JavaAdapter;

/**
 * Seasar2用のアダブタです。
 * 
 * @author higa
 * 
 */
public class S2Adapter extends JavaAdapter {

	public void setDestination(Destination destination) {
		RemotingDestination dest = (RemotingDestination) destination;
		dest.setFactory(new S2Factory());
		super.setDestination(dest);
	}

}
