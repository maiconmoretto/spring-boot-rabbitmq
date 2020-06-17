package com.springbootrabbitmq.service.consumer;

import java.io.IOException;

import java.util.concurrent.TimeoutException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

@Service
public class Consumer {

	public void consume() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare("spring-boot-rabbitmq", false, false, false, null);

		channel.basicConsume("spring-boot-rabbitmq", true, (consumerTag, message) -> {
			String m = new String(message.getBody(), "UTF-8");
			System.out.println("I Just recieved a message = " + m);
		}, consumerTag -> {
		});
	}
}
