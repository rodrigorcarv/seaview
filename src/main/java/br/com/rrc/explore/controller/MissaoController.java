package br.com.rrc.explore.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/missao")
public class MissaoController {
	
	@RequestMapping(value = "/explorar-fossa", method = RequestMethod.POST, consumes = "text/plain", produces = "text/plain")
	public @ResponseBody String missao (@RequestBody String comandos){

		//TODO: Criar servico para converter os comandos;
		
		//TODO: Criar servico para processar os comandos;
		
		//TODO: Retorna resuldo esperado
		
		return null;
	}
}
