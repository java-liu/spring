package queues;

import java.util.logging.Logger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {
	private static Logger logger = Logger.getLogger(NewTask.class.getName());
	private final static String TASK_QUEUE_NAME = "task_queue";
	public static void main(String[] args) throws Exception{
		logger.info("任务安排者开始分配任务:"+System.currentTimeMillis());
		//创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		//boolean durable = true;
		//channel.queueDecliare(TASK_QUEUE_NAME, durable, false, false, null);
		//durable = true时，是告诉RabbitMQ，这个队列要持久化
		channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);
		//分发消息
		for(int i = 0;i < 5; i++){
			String message = "Hello World "+ i;
			channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			System.out.println("[x] Sent '"+ message + "'");
		}
		logger.info("任务都分配任务完成：" + System.currentTimeMillis());
		channel.close();
		connection.close();
		
	}

}
