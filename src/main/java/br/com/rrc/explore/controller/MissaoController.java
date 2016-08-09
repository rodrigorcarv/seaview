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
import br.com.rrc.explore.service.MissaoService;

@RestController
@RequestMapping(value="/missao")
public class MissaoController {

	@Autowired
	ComandoConvert comandoConvert;
	
	@Autowired
	MissaoService missaoService;

	@RequestMapping(value = "/explorar-fossa", method = RequestMethod.POST, consumes = "text/plain", produces = "text/plain")
	public @ResponseBody String missao (@RequestBody String comandos){

		List<Comando> listaComandos = comandoConvert.string2Comandos(comandos);

		return missaoService.explorarOceano(listaComandos);
	}
}
