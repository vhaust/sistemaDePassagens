/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ap22020.sistema_de_passagens.model;

/**
 * Classe que representa uma cidade.
 * 
 * @author Otávio Camargo Marciano - 201900244
 */
public class Cidade {

	private String nome;
	private String estado;
	private CodigoIATA codigo;

	/**
	 * Construtor que inicializa o objeto Cidade a partir dos par�metros nome,
	 * estado e codigo(CodigoIATA).
	 * 
	 * @param nome
	 * @param estado
	 * @param codigo
	 */
	public Cidade(String nome, String estado, CodigoIATA codigo) {
		this.nome = nome;
		this.estado = estado;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public CodigoIATA getCodigo() {
		return codigo;
	}

	public void setCodigo(CodigoIATA codigo) {
		this.codigo = codigo;
	}

}
