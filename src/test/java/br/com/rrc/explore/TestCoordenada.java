package br.com.rrc.explore;

import org.junit.Assert;
import org.junit.Test;

import br.com.rrc.explore.beans.Coordenada;

public class TestCoordenada {
	
	@Test
	public void testIncrementaLatitudeComSucesso(){

		Coordenada coordenada = new Coordenada(0, 0, 0);
		coordenada.incrementaLatitude();
		
		Assert.assertEquals(1, coordenada.getLatitude());
	}
	
	@Test
	public void testDecrementaLatitudeComSucesso(){

		Coordenada coordenada = new Coordenada(0, 0, 0);
		coordenada.decrementaLatitude();;
		
		Assert.assertEquals(-1, coordenada.getLatitude());
	}
	
	@Test
	public void testIncrementaLogitudeComSucesso(){

		Coordenada coordenada = new Coordenada(0, 0, 0);
		coordenada.incrementaLongitude();
		
		Assert.assertEquals(1, coordenada.getLongitude());
	}
	
	@Test
	public void testDecrementaLogitudeComSucesso(){

		Coordenada coordenada = new Coordenada(0, 0, 0);
		coordenada.decrementaLongitude();
		
		Assert.assertEquals(-1, coordenada.getLongitude());
	}
	
	@Test
	public void testIncrementaAltitudeComSucesso(){

		Coordenada coordenada = new Coordenada(0, 0, -1);
		coordenada.incrementaAltitude();
		
		Assert.assertEquals(0, coordenada.getAltitude());
	}
	
	@Test
	public void testDecrementaAltitudeComSucesso(){

		Coordenada coordenada = new Coordenada(0, 0, 0);
		coordenada.decrementaAltitude();
		
		Assert.assertEquals(-1, coordenada.getAltitude());
	}
}
