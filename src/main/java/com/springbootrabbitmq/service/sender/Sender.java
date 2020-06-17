package com.springbootrabbitmq.service.sender;

import java.io.IOException;

import java.util.concurrent.TimeoutException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Service
public class Sender {

	public void send(String message) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.newConnection()) {
			Channel channel = connection.createChannel();
			channel.queueDeclare("spring-boot-rabbitmq", false, false, false, null);
			channel.basicPublish("", "spring-boot-rabbitmq", false, null, message.getBytes());
			System.out.println("Message sent to the RabbitMQ Successfully");
		} catch (IOException e) {
			throw new IOException(e);
		}
	}
}
