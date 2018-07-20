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
		//创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		//创建连接
		Connection connection = factory.newConnection();
		
		//创建频道
		Channel channel = connection.createChannel();
		//声明一个队列，在RabbitMQ中，队列是幂等性的（一个幂等操作的特点是其任何多次执行所产生的影响均与一次执行的影响相同），也就是说，如果不存在，就创建，如果存在，不会对已有的队列有任何影响。
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		System.out.println("C [x] Waiting for message. To exit press CTRL+C");
		//DefaultConsumer类实现了Consumer接口，通过传入一个频道，告诉服务器我们需要哪个频道的信息，如果频道中有消息，就会执行回调函数handleDelivery
		Consumer consumer = new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag,Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException{
				String message = new String(body,"UTF-8");
				System.out.println("C [x] Recevied '" + message +"'");
			}
		};
		//自动回复队列应答 --RabbitMQ中的消息确认机制
		channel.basicConsume(QUEUE_NAME, consumer);
	}

}
