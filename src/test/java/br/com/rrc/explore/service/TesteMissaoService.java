package br.com.rrc.explore.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rrc.explore.beans.enums.Comando;
import br.com.rrc.explore.service.MissaoService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TesteMissaoService {
	
	@Autowired
	MissaoService missaoService;

	@Test
	public void explorarOceandoSucesso() {
		
		List<Comando> comandos = new ArrayList<>();
		comandos.add(Comando.ESQUERDA);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.DIREITA);
		comandos.add(Comando.DESCER);
		comandos.add(Comando.DESCER);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.MOVER);
		comandos.add(Comando.SUBIR);
		comandos.add(Comando.SUBIR);
		
		String coordenadaFinal =  missaoService.explorarOceano(comandos);
		
		String coordenadaEsperada = "-1 2 0 NORTE";
		Assert.assertEquals(coordenadaEsperada , coordenadaFinal);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void explorarOceandoListaDeComandosVazia() {
		
		List<Comando> comandos = new ArrayList<>();
			
		missaoService.explorarOceano(comandos);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void explorarOceandoListaDeComandosNula() {
		
		List<Comando> comandos = null;
			
		missaoService.explorarOceano(comandos);
	}
}
