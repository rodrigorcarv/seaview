package br.com.rrc.explore.beans;

import java.util.Optional;

import br.com.rrc.explore.beans.enums.Direcao;
import br.com.rrc.explore.exceptions.PosicaoSubimarinoInvalidaException;

public class Submarino {

	private Optional<Coordenada> coordenada;
	private Optional<Direcao> direcao;

	public Submarino(Optional<Coordenada> coordenada, Optional<Direcao>direcao) {
		super();
		this.coordenada = coordenada;
		this.direcao = direcao;
	}

	public Optional<Coordenada> getCoordenada() {
		return coordenada;
	}

	public Optional<Direcao> getDirecao() {
		return direcao;
	}

	public void setDirecao(Optional<Direcao> direcao) {
		this.direcao = direcao;
	}

	public void virarEsquerda() {
		
		if (direcao.isPresent()) {
			this.direcao = Optional.ofNullable(direcao.get().virarEsqueda());
		}
	}

	public void virarDireita() {

		if (direcao.isPresent()) {
			this.direcao = Optional.ofNullable(direcao.get().virarDireita());
		}
	}
	
	public void subir() {
		
		if (coordenada.isPresent()) {
			
			if (coordenada.get().getAltitude() == 0) {
				throw new PosicaoSubimarinoInvalidaException(coordenada.get());
			}
			coordenada.get().incrementaAltitude();
		}
	}
	
	public void descer() {
		if (coordenada.isPresent()) {
			coordenada.get().decrementaAltitude();
		}
	}

	public void navegar() {
		
		if (direcao.isPresent()) {
			direcao.get().navegar(coordenada);
		}
	}

	public String formataResultado() {

		if (coordenada.isPresent() && coordenada.isPresent()) {

			return String.format("%s %s %s %s", 
					coordenada.get().getLatitude(),
					coordenada.get().getLongitude(),
					coordenada.get().getAltitude(),
					direcao.get());
		}

		return toString();
	}
	
	
}
