package br.com.rrc.explore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rrc.explore.beans.enums.Comando;
import br.com.rrc.explore.beans.enums.Direcao;
import br.com.rrc.explore.convert.ComandoConvert;

@RestController
@RequestMapping(value="/missao")
public class MissaoController {

	@Autowired
	ComandoConvert comandoConvert;

	@RequestMapping(value = "/explorar-fossa", method = RequestMethod.POST, consumes = "text/plain", produces = "text/plain")
	public @ResponseBody String missao (@RequestBody String comandos){

		List<Comando> listaComandos = comandoConvert.string2Comandos(comandos);

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
