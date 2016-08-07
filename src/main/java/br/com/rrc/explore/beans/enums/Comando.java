package br.com.rrc.explore.beans.enums;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public enum Comando {
	
	ESQUERDA("L"),
	DIREITA("R"),
	MOVER("M"),
	DESCER("D"),
	SUBIR("U");
	
	private static final String O_COMANDO_INFORMADO_ESTA_INVALIDO = "O comando %s esta inválido";
	private String sigla;
	
	Comando (String sigla) {
		this.sigla = sigla;
	}	

	public String getSigla() {
		return sigla;
	}
	
	/**
	 * Faz a conversao de uma String que contem as intrucoes(comandos)
	 * da sonda para uma {@link List} de {@link Comando};
	 * 
	 * Caso os comandos informados em forma de {@link String} nao 
	 * constem na lista de enum seram considerados invalidos.
	 * 
	 * Para a instrucao ser valida ela nao pode ser nula, vazio ou espaco em branco
	 * 
	 * @param comando
	 * @return {@link List} de {@link Comando}
	 * @throws ComandoInvalidoException essa excecao pode ocorrer caso a instrucao seja
	 *         invalida
	 **/
	public static List<Comando> parseString2Comando(String instrucao) {
		
		if (StringUtils.isBlank(instrucao)) {
			throw new IllegalArgumentException(instrucao);
		}
		
		char instrucoes[] = instrucao.toCharArray();
		List<Comando> comandos = new ArrayList<Comando>();

		for (int i = 0; i < instrucoes.length; i++) {
			
			Comando comando = buscaComando(instrucoes[i]);
			comandos.add(comando);
		}
		
		return comandos;
	}
	
	/**
	 * Busca no enum {@link Comando} o comando informado devolvendo o mesmo em forma de 
	 * {@link Comando}
	 * Caso nao exista sera exibida a excecao de {@link IllegalArgumentException}.
	 * 
	 * @param instrucao 
	 * @return {@link Comando}
	 * @throws ComandoInvalidoException essa excecao pode ocorrer caso a instrucao seja
	 *         invalida
	 */
	public static Comando buscaComando(char instrucao) {

		for (Comando comando : Comando.values()) {
			
			if (comando.sigla.equals(String.valueOf(instrucao))){
				return comando;
			}
		}
		throw new IllegalArgumentException(String.format(O_COMANDO_INFORMADO_ESTA_INVALIDO, instrucao));
	}
}
