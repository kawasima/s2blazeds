package flex.samples.service;

import java.util.Random;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.DestroyMethod;
import org.seasar.framework.container.annotation.tiger.InstanceType;

import flex.messaging.MessageBroker;
import flex.messaging.messages.AsyncMessage;
import flex.messaging.util.UUIDUtils;

/**
 * Feed用のアクションです。
 * 
 * @author higa
 * 
 */
@Component(instance = InstanceType.SINGLETON)
public class FeedService {

	/**
	 * Feed用のスレッドです。
	 */
	protected FeedThread thread;

	/**
	 * Feedを開始します。
	 */
	public synchronized void start() {
		if (thread == null) {
			thread = new FeedThread();
			thread.start();
		}
	}

	/**
	 * Feedを終了します。
	 */
	@DestroyMethod
	public synchronized void stop() {
		if (thread != null) {
			thread.running = false;
			thread = null;
		}
	}

	/**
	 * Feed用のスレッドです。
	 * 
	 */
	protected static class FeedThread extends Thread {

		/**
		 * 稼動中かどうかです。
		 */
		protected boolean running = true;

		public void run() {
			MessageBroker msgBroker = MessageBroker.getMessageBroker(null);
			String clientID = UUIDUtils.createUUID();
			Random random = new Random();
			double initialValue = 35;
			double currentValue = 35;
			double maxChange = initialValue * 0.005;
			while (running) {
				double change = maxChange - random.nextDouble() * maxChange * 2;
				double newValue = currentValue + change;
				if (currentValue < initialValue + initialValue * 0.15
						&& currentValue > initialValue - initialValue * 0.15) {
					currentValue = newValue;
				} else {
					currentValue -= change;
				}
				AsyncMessage msg = new AsyncMessage();
				msg.setDestination("feed");
				msg.setClientId(clientID);
				msg.setMessageId(UUIDUtils.createUUID());
				msg.setTimestamp(System.currentTimeMillis());
				msg.setBody(new Double(currentValue));
				msgBroker.routeMessageToService(msg, null);
				System.out.println("" + currentValue);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}