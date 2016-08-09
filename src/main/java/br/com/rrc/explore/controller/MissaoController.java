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

				direcao = busula(Comando.ESQUERDA, direcao);
				break;

			case DIREITA:

				direcao = busula(Comando.DIREITA, direcao);
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

	private Direcao busula(Comando comando, Direcao direcao) {

		if (Direcao.NORTE.equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return Direcao.OESTE;
		} else if (Direcao.NORTE.equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return Direcao.LESTE;
		} else if (Direcao.LESTE.equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return Direcao.NORTE;
		} else if (Direcao.LESTE.equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return Direcao.SUL; 
		} else if (Direcao.SUL.equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return Direcao.LESTE;
		} else if (Direcao.SUL.equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return Direcao.OESTE;
		} else if (Direcao.OESTE.equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return Direcao.SUL;
		} else if (Direcao.OESTE.equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return Direcao.NORTE;
		}
		
		return direcao;
	}
}
