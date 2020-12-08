/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ap22020.sistema_de_passagens;

import javax.swing.JOptionPane;

/**
 * Classe que representa um cart�o.
 * 
 * @author Otávio Camargo Marciano - 201900244
 */
public class Cartao {

	private Conta conta;
	private int numero;
	private TipoCartao tipo;
	private double limite;
	private double limiteDisponivel; // limite disponivel para compra credito
	private int senha;

	/**
	 * Construtor para incializar o objeto Cartao sem par�metros.
	 */
	public Cartao() {

	}

	/**
	 * Construtor para inicializar o objeto Cartao a partir da conta, n�mero e tipo.
	 * 
	 * @param conta
	 * @param numero
	 * @param tipo
	 */
	public Cartao(Conta conta, int numero, TipoCartao tipo) {
		this.conta = conta;
		this.numero = numero;
		this.tipo = tipo;
	}

	/**
	 * Contrutor para inicializar o objeto a partir da conta, n�mero, tipo e limite.
	 * 
	 * @param conta
	 * @param numero
	 * @param tipo
	 * @param limite
	 */
	public Cartao(Conta conta, int numero, TipoCartao tipo, double limite) {
		if (this.tipo == TipoCartao.CRED) {

			this.conta = conta;
			this.numero = numero;
			this.tipo = tipo;
			this.setLimite(limite);
		} else {
			JOptionPane.showMessageDialog(null,
					String.format(
							"[CARTÃO DE DÉBITO NÃO POSSUI O ATRIBUTO LIMITE]\n[UM CARTÃO DE DÉBITO FOI CRIADO]",
							""),
					"Aviso", 2);
			this.conta = conta;
			this.numero = numero;
			this.tipo = TipoCartao.DEB;
		}

	}

	/**
	 * M�todo para realizar uma compra no d�bito a partir do valor e local.
	 * 
	 * @param valor
	 * @param local
	 * @return
	 */
	public boolean compraDebito(double valor, String local) {

		if (conta.realizaCompra(local, valor)) {
			String men = String.format("Valor das Passgens:R$%,.2f\n", valor);
			System.out.println(men + "Compra bem sucedida!");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "[SALDO INSUFICIENTE]", "Saldo insuficiente", 0);
		}
		return false;
	}

	/**
	 * M�todo para realiar uma compra no cr�dito a partir do titular, n�mero, valor
	 * e local.
	 * 
	 * @param titular
	 * @param numero
	 * @param valor
	 * @param local
	 * @return
	 */
	public boolean compraCredito(String titular, int numero, double valor, String local) {

		if (limiteDisponivel >= valor) {
			conta.realizaCompra(local, valor);
			String men = String.format("Valor das Passgens:R$%,.2f\n", valor);
			System.out.println(men + "Compra bem sucedida!");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "[LIMITE ATINGIDO]", "Limite atingido", 0);
			return false;
		}
	}

	/**
	 * M�todo para autenticar o Cartao a partir do titular, n�mero e senha.
	 * 
	 * @param titular
	 * @param numero
	 * @param senha
	 * @return
	 */
	public boolean autentica(String titular, int numero, int senha) {
		if (this.senha == senha && this.numero == numero && this.conta.getNomeTitular() == titular) {
			return true;
		} else {
			System.out.println("Dados Invalidos!");
			return false;
		}
	}

	public String getTipo() {
		return tipo.getTipo();
	}

	public void setTipo(TipoCartao tipo) {
		this.tipo = tipo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public void setLimiteDisponivel(double limiteDisponivel) {
		this.limiteDisponivel = limiteDisponivel;
	}

	public double getLimiteDisponivel() {
		return limiteDisponivel;
	}

}
