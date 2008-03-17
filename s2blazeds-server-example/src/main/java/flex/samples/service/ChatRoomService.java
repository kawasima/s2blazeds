package flex.samples.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

import flex.messaging.MessageBroker;
import flex.messaging.MessageDestination;
import flex.messaging.services.MessageService;

/**
 * chat部屋用のサービスです。
 * 
 * @author higa
 * 
 */
@Component(instance = InstanceType.SINGLETON)
public class ChatRoomService {

	/**
	 * 部屋名のリストです。
	 */
	protected List<String> rooms = Collections
			.synchronizedList(new ArrayList<String>());

	/**
	 * 部屋名のリストを返します。
	 * 
	 * @return 部屋名のリスト
	 */
	public List<String> getRoomList() {
		return rooms;
	}

	/**
	 * 部屋を作成します。
	 * 
	 * @param id
	 *            部屋名
	 */
	public void createRoom(String id) {
		if (rooms.contains(id)) {
			throw new RuntimeException("Room(" + id + " already exists");
		}
		String serviceId = "message-service";
		MessageBroker broker = MessageBroker.getMessageBroker(null);
		MessageService service = (MessageService) broker.getService(serviceId);
		MessageDestination destination = (MessageDestination) service
				.createDestination(id);
		if (service.isStarted()) {
			destination.start();
		}
		rooms.add(id);
	}
}