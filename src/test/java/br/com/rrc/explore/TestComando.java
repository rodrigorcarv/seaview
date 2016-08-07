package br.com.rrc.explore;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.explore.beans.enums.Comando;
import br.com.rrc.explore.convert.ComandoConvert;

public class TestComando {
	
	@Test 
	public void testBuscarComandoL() {
		
		char instrucao = 'L';
		Assert.assertEquals(Comando.ESQUERDA, Comando.buscaComando(instrucao));
	}
	
	@Test 
	public void testBuscarComandoR() {
		
		char instrucao = 'R';
		Assert.assertEquals(Comando.DIREITA, Comando.buscaComando(instrucao));
	}
	
	@Test 
	public void testBuscarComandoM() {
		
		char instrucao = 'M';
		Assert.assertEquals(Comando.MOVER, Comando.buscaComando(instrucao));
	}

	@Test 
	public void testBuscarComandoD() {
		
		char instrucao = 'D';
		Assert.assertEquals(Comando.DESCER, Comando.buscaComando(instrucao));
	}
	
	@Test 
	public void testBuscarComandoU() {
		
		char instrucao = 'U';
		Assert.assertEquals(Comando.SUBIR, Comando.buscaComando(instrucao));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testBuscarComandoVazio() {
		
		char instrucao = ' ';
		Comando.buscaComando(instrucao);
	}
	

	@Test
	public void testParseString2ComandoComSucesso(){
		
		String listaComandos = "LMRDDMMUU";
		List<Comando> comandos = Comando.parseString2Comando(listaComandos);
		
		List<Comando> listaComandosEsperado = new ArrayList<>();
		listaComandosEsperado.add(Comando.ESQUERDA);
		listaComandosEsperado.add(Comando.MOVER);
		listaComandosEsperado.add(Comando.DIREITA);
		listaComandosEsperado.add(Comando.DESCER);
		listaComandosEsperado.add(Comando.DESCER);
		listaComandosEsperado.add(Comando.MOVER);
		listaComandosEsperado.add(Comando.MOVER);
		listaComandosEsperado.add(Comando.SUBIR);
		listaComandosEsperado.add(Comando.SUBIR);
		
		Assert.assertEquals(listaComandosEsperado, comandos);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParseString2ComandoVazio() {
		
		String instrucao = "";
		Comando.parseString2Comando(instrucao);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParseString2ComandoEspacoEmBranco() {
		
		String instrucao = " ";
		Comando.parseString2Comando(instrucao);
	}
}
