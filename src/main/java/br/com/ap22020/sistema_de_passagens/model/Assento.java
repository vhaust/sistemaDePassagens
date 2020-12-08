package br.com.ap22020.sistema_de_passagens.model;

/**
 * Classe que representa um assento no Voo
 *
 * @author Ot�vio Camargo Marciano - 201900244
 * 
 * 
 */

public class Assento {

	private boolean status = false;
	private String posicao;

	/**
	 * Construtor para inicializar o objeto a partir do status e posi��o.
	 * 
	 * @param status
	 * @param posicao
	 */
	public Assento(boolean status, String posicao) {
		this.status = status;
		this.posicao = posicao;
	}

	/**
	 * M�todo que retorna uma String sobre o status do assento.
	 * 
	 * @return
	 */
	public String isStatus() {
		if (status == true) {
			return "Assento ocupado!";
		} else {
			return "Assento desocupado!";
		}
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

}
