package br.com.rrc.explore.beans;

import br.com.rrc.explore.beans.enums.Direcao;

public class Submarino {

	private Coordenada coordenada;
	private Direcao direcao;
	
	public Submarino(Coordenada coordenada, Direcao direcao) {
		super();
		this.coordenada = coordenada;
		this.direcao = direcao;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public Direcao getDirecao() {
		return direcao;
	}
	
	public void virarEsquerda() {
		this.direcao = direcao.virarEsqueda();
	}
	
	public void virarDireita() {
		this.direcao = direcao.virarDireita();
	}

	@Override
	public String toString() {
		return String.format("Submarino [coordenada=%s, direcao=%s]", coordenada, direcao);
	}
	
	public String formataResultado() {
		
		if (coordenada != null && direcao != null) {
			
			return String.format("%s %s %s %s", 
					coordenada.getLatitude(),
					coordenada.getLongitude(),
					coordenada.getAltitude(),
					direcao);
		}
		
		return toString();
	}
}
