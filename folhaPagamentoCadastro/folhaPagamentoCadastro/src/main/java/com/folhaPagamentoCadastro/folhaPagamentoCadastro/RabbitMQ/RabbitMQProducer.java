package com.folhaPagamentoCadastro.folhaPagamentoCadastro.RabbitMQ;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.folhaPagamentoCadastro.folhaPagamentoCadastro.config.RabbitMQConfig;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.FolhaPagamento;

@RestController
@Component
public class RabbitMQProducer {

	@Autowired
	private RabbitTemplate template;
	
	
	public String cadastrar(@RequestBody @Valid FolhaPagamento folhaPagamento)  throws ClientProtocolException, IOException {
        
		RabbitMQConfig config = new RabbitMQConfig();
		config.queue2();
		
		template.convertAndSend(folhaPagamento);
        		
		return "Folha pagamento recebido";
	}
}
