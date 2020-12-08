/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ap22020.sistema_de_passagens.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a conta de uma pessoa.
 * 
 * @author Otávio Camargo Marciano - 201900244
 */
public class Conta {

	private String nomeTitular;
	private int numero;
	private String tipo;
	private double saldo;
	private Cartao cartao;

	private List<String> compras = new ArrayList<>();

	/**
	 * Construtor que inicializa o objeto Conta sem par�metros.
	 */
	public Conta() {

	}

	/**
	 * Construtor que inicializa o objeto Conta com os par�metros nomeTitular,
	 * numero, tipo e saldo.
	 * 
	 */
	public Conta(String nomeTitular, int numero, String tipo, double saldo) {
		this.nomeTitular = nomeTitular;
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = saldo;

	}

	/**
	 * M�todo que realiza uma compra com os par�metros local e valor retornando um
	 * boolean.
	 */
	public boolean realizaCompra(String local, double valor) {
		if (valor < this.saldo) {
			saldo -= valor;
			compras.add(String.format("[Local realizado a compra:%s - Valor:R$%,.2f", local, valor));
			return true;
		}
		return false;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
