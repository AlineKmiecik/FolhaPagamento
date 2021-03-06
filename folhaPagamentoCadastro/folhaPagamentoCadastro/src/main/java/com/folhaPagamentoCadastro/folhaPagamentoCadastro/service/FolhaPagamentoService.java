package com.folhaPagamentoCadastro.folhaPagamentoCadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folhaPagamentoCadastro.folhaPagamentoCadastro.models.FolhaPagamento;
import com.folhaPagamentoCadastro.folhaPagamentoCadastro.repositories.FolhaPagamentoRepository;

@Service
public class FolhaPagamentoService {

	FolhaPagamentoRepository folhaPagamentoRepository;
	
	public static final List<FolhaPagamento> folhasPagamento = new ArrayList();

	public final String FolhasPagamento = null;
	
	public List<FolhaPagamento> create(FolhaPagamento folhaPagamento) {
		
		folhasPagamento.add(folhaPagamento);
		return folhasPagamento;
	}
	
	public List<FolhaPagamento> listar() {
		return folhasPagamento;
	}
	
	public double total() {
		double total = 0.0;
		
		for (FolhaPagamento folhaPagamento : folhasPagamento) {
			total += folhaPagamento.getBruto();
		}
		return total;
	}
	
	public double media() {

		double total = 0.0;
		return total;
	}
}
