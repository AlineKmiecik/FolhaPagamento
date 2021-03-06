package com.folhaPagamentoCadastro.folhaPagamentoCadastro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.AMQP.Queue;
import com.rabbitmq.client.ConnectionFactory;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class RabbitMQConfig {
	 @Value("${spring.rabbitmq.queue}")
     private String queue;
	 
	 @Value("${spring.rabbitmq.queue2}")
	 private String queue2;
	 	
	//Gera uma nova fila
	@Bean
	public org.springframework.amqp.core.Queue queue() {
	    return new org.springframework.amqp.core.Queue(queue, true);
	}
	
	@Bean
	public org.springframework.amqp.core.Queue queue2() {
		return new org.springframework.amqp.core.Queue(queue2, true);
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
	    return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(org.springframework.amqp.rabbit.connection.ConnectionFactory connection) {
		RabbitTemplate template = new RabbitTemplate(connection);
		template.setMessageConverter(messageConverter());
		return template;
		
	}
}
