package br.com.rrc.explore.convert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import br.com.rrc.explore.beans.enums.Comando;

@Component
public class ComandoConvert {
	
	private static final String COOMANDOS   = "\\s*([A-Z]+)\\s*";
	
	/**
	 * Cria uma {@link List} de {@link Comando}  com base nas string fornecidas.
	 * 
	 * @param comandos comandos a serem convertidos
	 * @return {@link List} de {@link Comando} 
	 */
	public List<Comando> string2Comandos(String comandos) {
		
		Pattern patternComando = Pattern.compile(COOMANDOS);
		Matcher matcherComandos = getMatcher(patternComando, comandos);
		
		return Comando.parseString2Comando(matcherComandos.group(1));
	}
	
	/**
	 * Obtem o {@link Matcher} com base nos paramentros informados
	 * 
	 * @param pattern {@link Pattern} 
	 * @param token texto a ser virificado se atendo o  {@link Pattern} 
	 * @return Retorna o {@link o Matcher} do token
	 * 
	 * @throws IllegalArgumentException Exececao sera disparada caso nao ocorra o {@link Matcher} 
	 *                                  do token.
	 */
	private Matcher getMatcher(Pattern pattern, String token) {

		final Matcher matcher = pattern.matcher(token);
		
		if (!matcher.matches()) {
			throw new IllegalArgumentException(String.format("Linha %s esta invalida", token));
		}
		
		return matcher;
	}

}
