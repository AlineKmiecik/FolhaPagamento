package com.folhaPagamentoCadastro.folhaPagamentoCadastro.RabbitMQ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.folhaPagamentoCadastro.folhaPagamentoCadastro.config.RabbitMQConfig;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.FolhaPagamento;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.service.FolhaPagamentoService;

@Component
public class RabbitMQConsume {
	@Autowired
    FolhaPagamentoService folhaPagamentoService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listener(@Payload FolhaPagamento folhaPagamento) throws ClientProtocolException, IOException {
        List<FolhaPagamento> folhasPagamento = new ArrayList();
        folhasPagamento = folhaPagamentoService.create(folhaPagamento);
        
        
        //enviar mensagem
        RabbitMQProducer produtor = new RabbitMQProducer();
        RabbitMQConfig config = new RabbitMQConfig();
		config.queue2();
    }    
}
