package com.springbootrabbitmq.controller;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springbootrabbitmq.service.sender.Sender;
import com.springbootrabbitmq.service.consumer.Consumer;

@RestController
@RequestMapping(value = "/api/v1/rabbitmq/")
public class SpringBootRabbitmqController {

	@Autowired
	Sender sender;
	
	@Autowired
	Consumer consumer;

	@GetMapping(value = "/producer")
	public void producer() throws IOException, TimeoutException {
		sender.send("Hello i am a message ;) with timestamp : " + System.currentTimeMillis() );
	}
		
	@GetMapping(value = "/consumer")
	public void consumer() throws IOException, TimeoutException {		
		consumer.consume();
	}
}
