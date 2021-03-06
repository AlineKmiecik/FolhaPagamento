package com.folhaPagamentoCadastro.folhaPagamentoCadastro.models;

import java.io.Serializable;


public class FolhaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int mes;
	private int ano;
	private int horas;
	private double valor;
	private double bruto;
	private double irrf;
	private double inss;
	private double  fgts;
	private double liquido;
	private Funcionario funcionario;
	
	public FolhaPagamento() {
		mes =0;
		ano = 0;
		horas = 0;
		valor = 0;
		bruto = 0.0;
		irrf = 0.0;
		inss = 0.0;
		fgts = 0.0;
		liquido = 0.0;
		funcionario = new Funcionario();
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getBruto() {
		return bruto;
	}

	public void setBruto(double bruto) {
		this.bruto = bruto;
	}

	public double getIrrf() {
		return irrf;
	}

	public void setIrrf(double irrf) {
		this.irrf = irrf;
	}

	public double getInss() {
		return inss;
	}

	public void setInss(double inss) {
		this.inss = inss;
	}

	public double getFgts() {
		return fgts;
	}

	public void setFgts(double fgts) {
		this.fgts = fgts;
	}

	public double getLiquido() {
		return liquido;
	}

	public void setLiquido(double liquido) {
		this.liquido = liquido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
}
