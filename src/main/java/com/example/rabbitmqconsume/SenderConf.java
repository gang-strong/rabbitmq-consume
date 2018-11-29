package com.example.rabbitmqconsume;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConf {

	@Bean
	public Queue dateQueue(){
		return new Queue("datequeue");
	}
	
	@Bean
	public Queue objQueue(){
		return new Queue("objectQueue");
	}
}
