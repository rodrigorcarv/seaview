package br.com.rrc.explore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rrc.explore.beans.Coordenada;
import br.com.rrc.explore.beans.Submarino;
import br.com.rrc.explore.beans.enums.Comando;
import br.com.rrc.explore.beans.enums.Direcao;
import br.com.rrc.explore.service.MissaoService;

@Service
public class MissaoServiceImpl implements MissaoService {

	private static final String PARAMETRO_INFORMADO_LISTA_COMANDO_ESTA_NULO_OU_VAZIO = "N\u00E3o \u00E9 poss\u00EDvel iniciar a exploca\u00E7\u00E3o do oceano, pois a lista de comandos esta vazia ou nula";

	@Override
	public Submarino explorarOceano(List<Comando> listaComandos) {
		
		if (listaComandos == null || listaComandos.size() <=0 ) {
			throw new IllegalArgumentException(PARAMETRO_INFORMADO_LISTA_COMANDO_ESTA_NULO_OU_VAZIO);
		}

		Coordenada coordenada = new Coordenada(0, 0, 0);
		Submarino submarino = new Submarino(coordenada, Direcao.NORTE);
		
		for (Comando comando : listaComandos) {

			switch (comando) {

			case ESQUERDA:

				submarino.virarEsquerda(); 
				break;

			case DIREITA:

				submarino.virarDireita();
				break;

			case MOVER:

				submarino.navegar();
				break;

			case SUBIR:

				submarino.getCoordenada().incrementaAltitude();
				break;

			case DESCER:

				submarino.getCoordenada().decrementaAltitude();
				break;

			}
		}
		return submarino;
	}
}