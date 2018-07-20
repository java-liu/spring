package queues;

import java.io.IOException;
import java.util.logging.Logger;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Worker2 {
	private static Logger logger = Logger.getLogger(Worker2.class.getName());
	private final static String TASK_QUEUE_NAME = "task_queue";
	public static void main(String[] args) throws Exception{
		logger.info("开始接收任务" + System.currentTimeMillis());
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();
		
		channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);
		System.out.println("Worker2 [*] Waiting for message.To exit press Ctrl+C");
		//每次从队列中取一个
		channel.basicQos(1);
		
		final Consumer consumer = new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag,Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException{
				String message = new String(body,"UTF-8");
				System.out.println("Worker2[x] Recevied '" + message +"'");
				try{
					doWork(message);
				}finally{
					System.out.println("Worker2[x] done");
					//消息处理确认完成
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
				
				logger.info("任务执行完毕！"+System.currentTimeMillis());
			}
		};
		channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
	}
	
	public static void doWork(String task){
		try{
			Thread.sleep(1000);//暂停1秒钟
		}catch(Exception e){
			Thread.currentThread().interrupt();
		}
	}


}
