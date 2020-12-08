package br.com.ap22020.sistema_de_passagens.passagens;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import sistema.br.com.ap22020.sistema_de_passagens.model.Assento;
import sistema.br.com.ap22020.sistema_de_passagens.model.Aviao;
import sistema.br.com.ap22020.sistema_de_passagens.model.Cidade;
import sistema.br.com.ap22020.sistema_de_passagens.model.CodigoIATA;
import sistema.br.com.ap22020.sistema_de_passagens.model.Voo;

/**
 * Classe que registra voos.
 * 
 *
 */
public class RegistraVooTeste {

	List<Voo> voos = new ArrayList<>();

	RegistraVooTeste() {
		Assento[][] av = new Assento[10][20];
		for (int i = 0; i < av.length; i++) {
			for (int j = 0; j < av[i].length; j++) {
				av[i][j] = new Assento(false, "i j");
			}
		}

		Aviao a1 = new Aviao("Boeing 737", 100);

		String horarioSaida = LocalDateTime.of(2020, 12, 04, 15, 30, 00)
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		String horarioChegada = LocalDateTime.of(2020, 12, 05, 15, 30, 00)
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

		List<Cidade> paradas = new ArrayList<>();

		Cidade cidadePartida = new Cidade("Goias", "Goiania", CodigoIATA.GYN);
		Cidade cidadeParada = new Cidade("Estado", "Cidade Qualquer", CodigoIATA.ZMD);
		paradas.add(cidadeParada);
		Cidade cidadeDestino = new Cidade("S�o Paulo", "Sao Paulo", CodigoIATA.SOD);

		Voo v1 = new Voo(av, a1, horarioSaida, horarioChegada, paradas, cidadeDestino, cidadePartida);

		voos.add(v1);

	}

}
