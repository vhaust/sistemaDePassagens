/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ap22020.sistema_de_passagens;

/**
 * Tipos de cartões que podem ser usados.
 * 
 * @author ocmma
 */
public enum TipoCartao {
	DEB("Débito"), CRED("Crédito");

	private final String tipo;

	/**
	 * Tipo do Cartão
	 * 
	 * @param tipo
	 */
	TipoCartao(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

}
