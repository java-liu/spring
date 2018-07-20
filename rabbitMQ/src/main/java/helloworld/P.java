package helloworld;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class P {
	private final static String QUEUE_NAME = "hello";
	public static void main(String[] args) throws Exception{
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		try {
			//创建一个连接
			Connection connection = factory.newConnection();
			//创建一个频道
			Channel channel = connection.createChannel();
			
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			
			//发送消息到队列中
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
			System.out.println("P [X] Sent '" + message + "'");
			
			channel.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
