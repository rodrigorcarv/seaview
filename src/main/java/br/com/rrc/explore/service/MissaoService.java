package br.com.rrc.explore.service;

import java.util.List;

import br.com.rrc.explore.beans.Submarino;
import br.com.rrc.explore.beans.enums.Comando;

public interface MissaoService {

	/**
	 * Metodo que atraves de um {@link List} de {@link Comando} informado
	 * realiza a exploracao do oceano.
	 * 
	 * Se os {@link Comando} informados estiverem vazios nulos sera disparada uma exececao.
	 * 
	 * @param comandos {@link List} de {@link Comando}
	 * 
	 * @return Submarino {@link Submarino};
	 */
	public Submarino explorarOceano(List<Comando> comandos);

}
