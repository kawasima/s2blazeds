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
