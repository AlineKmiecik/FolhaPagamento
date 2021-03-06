package com.folhaPagamentoCadastro.folhaPagamentoCadastro.controller;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.folhaPagamentoCadastro.folhaPagamentoCadastro.RabbitMQ.RabbitMQProducer;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.FolhaPagamento;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.Funcionario;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.service.FolhaPagamentoService;

@RestController
@RequestMapping(path = "/folha")
public class FolhaPagamentoController {
	
	@Autowired
	FolhaPagamentoService folhaPagamentoService;
	
	@PostMapping("/cadastrar")
    public ResponseEntity<FolhaPagamento> createCurso(@RequestBody @Valid FolhaPagamento folhaPagamento) throws ClientProtocolException, IOException{
        
        //cursoModel = converterCursoDto(cursoDto);
        List<FolhaPagamento> folhasPagamento = new ArrayList();
		
        folhasPagamento = folhaPagamentoService.create(folhaPagamento);
        
        RabbitMQProducer prod = new RabbitMQProducer();
        prod.cadastrar(folhaPagamento);
        
        	
        return new ResponseEntity<>(HttpStatus.CREATED);
        	
        /*}else {
        	return new ResponseEntity<>(cursoModel, HttpStatus.CONFLICT);
        }*/
        
    }
	
	
	  //GET /folha/listar
	@GetMapping("/listar")
    public ResponseEntity<Funcionario> getAll(){
    	
        return new ResponseEntity(folhaPagamentoService.listar(), HttpStatus.OK);
    }
	  
	//GET /folha/total
	@GetMapping("/total")
    public @ResponseBody double getTotal(){
    	
        return folhaPagamentoService.total();
    }
	
	  //GET /folha/media
	@GetMapping("/media")
    public @ResponseBody double getMedia(){
    	
        return folhaPagamentoService.media();
    }
	 


}
