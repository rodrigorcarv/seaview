package br.com.rrc.explore.convert;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.explore.beans.Comando;
import br.com.rrc.explore.convert.ComandoConvert;

public class TestConvertComando {
	
	@Test
	public void testConvertComandoComSucesso(){
		
		ComandoConvert comandoConvert = new ComandoConvert();
		String listaComandos = "LMRDDMMUU";
		List<Comando> comandos = comandoConvert.string2Comandos(listaComandos);
		
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
		
		Assert.assertEquals(listaComandos, comandos);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertComandoComFalha(){
		
		ComandoConvert comandoConvert = new ComandoConvert();
		String listaComandos = "XLMRDDMMUU";
		List<Comando> comandos = comandoConvert.string2Comandos(listaComandos);
		
		Assert.assertEquals(listaComandos, comandos);
	}
}
