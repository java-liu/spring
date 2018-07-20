package helloworld;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class C {
	private final static String QUEUE_NAME = "hello";
	public static void main(String[] args) throws Exception{
		//
		ConnectionFactory factory = new ConnectionFactory();
		
		Connection connection = factory.newConnection();
		
		//创建频道
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		System.out.println("C [x] Waiting for message. To exit press CTRL+C");
		
		Consumer consumer = new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag,Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException{
				String message = new String(body,"UTF-8");
				System.out.println("C [x] Recevied '" + message +"'");
			}
		};
		channel.basicConsume(QUEUE_NAME, consumer);
	}

}
