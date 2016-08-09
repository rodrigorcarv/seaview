package br.com.rrc.explore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rrc.explore.beans.enums.Comando;
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
		String direcao = "NORTE";

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

				case "NORTE":

					posicaoEntradaY++;
					break;

				case "LESTE":

					posicaoEntradaX++;
					break;

				case "SUL":

					posicaoEntradaY--;
					break;

				case "OESTE":

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

	private String busula(Comando comando, String direcao) {

		if ("NORTE".equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return "OESTE";
		} else if ("NORTE".equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return "LESTE";
		} else if ("LESTE".equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return "NORTE";
		} else if ("LESTE".equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return "SUL"; 
		} else if ("SUL".equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return "LESTE";
		} else if ("SUL".equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return "OESTE";
		} else if ("OESTE".equals(direcao) &&  Comando.ESQUERDA.equals(comando)) {
			return "SUL";
		} else if ("OESTE".equals(direcao) &&  Comando.DIREITA.equals(comando)) {
			return "NORTE";
		}
		return direcao;
	}
}
