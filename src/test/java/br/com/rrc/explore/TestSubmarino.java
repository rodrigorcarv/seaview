package br.com.rrc.explore;

import java.util.Optional;

import org.junit.Test;

import br.com.rrc.explore.beans.Coordenada;
import br.com.rrc.explore.beans.Submarino;
import br.com.rrc.explore.beans.enums.Direcao;

public class TestSubmarino {

	@Test 
	public void testSubirSubmarinoComSucesso(){

		int latitude = 0;
		int longitude = 0;
		int altitude = -1;
		Optional<Coordenada> coordenada = Optional.of(new Coordenada(latitude, longitude, altitude));
		Optional<Direcao> direcao = Optional.of(Direcao.NORTE);
		Submarino submarino = new Submarino(coordenada, direcao);
		submarino.subir();
		
	}
	
	@Test (expected=RuntimeException.class)
	public void testSubirSubmarinoCoordenadaInvalida(){

		int latitude = 0;
		int longitude = 0;
		int altitude = 0;
		Optional<Coordenada> coordenada = Optional.of(new Coordenada(latitude, longitude, altitude));
		Optional<Direcao> direcao = Optional.of(Direcao.NORTE);
		Submarino submarino = new Submarino(coordenada, direcao);
		submarino.subir();
		
	}
}
