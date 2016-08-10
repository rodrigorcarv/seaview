package br.com.rrc.explore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rrc.explore.beans.enums.Comando;
import br.com.rrc.explore.beans.enums.Direcao;
import br.com.rrc.explore.service.MissaoService;

@Service
public class MissaoServiceImpl implements MissaoService {

	private static final String PARAMETRO_INFORMADO_LISTA_COMANDO_ESTA_NULO_OU_VAZIO = "N\u00E3o \u00E9 poss\u00EDvel iniciar a exploca\u00E7\u00E3o do oceano, pois a lista de comandos esta vazia ou nula";

	@Override
	public String explorarOceano(List<Comando> listaComandos) {
		
		if (listaComandos == null || listaComandos.size() <=0 ) {
			throw new IllegalArgumentException(PARAMETRO_INFORMADO_LISTA_COMANDO_ESTA_NULO_OU_VAZIO);
		}
		
		int posicaoEntradaX = 0;
		int posicaoEntradaY = 0;
		int posicaoEntradaZ = 0;
		Direcao direcao = Direcao.NORTE;

		for (Comando comando : listaComandos) {

			switch (comando) {

			case ESQUERDA:

				direcao = direcao.virarEsqueda();
				break;

			case DIREITA:

				direcao = direcao.virarDireita();
				break;

			case MOVER:

				switch (direcao) {

				case NORTE:

					posicaoEntradaY++;
					break;

				case LESTE:

					posicaoEntradaX++;
					break;

				case SUL:

					posicaoEntradaY--;
					break;

				case OESTE:

					posicaoEntradaX--;
					break;
				}

				break;

			case SUBIR:

				posicaoEntradaZ++;
				break;

			case DESCER:

				posicaoEntradaZ--;
				break;

			}
		}
		return String.format("%s %s %s %s", posicaoEntradaX, posicaoEntradaY, posicaoEntradaZ, direcao);
	}
}