package br.com.rrc.explore.beans;

import java.util.Optional;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.rrc.explore.beans.enums.Direcao;

public class Submarino {

	private static final String COORDENADA_NVALIDA_O_SUBMARINO_ESTA_NO_NIVEL_DO_MAR = "Coordenada esta inv\u00E1lida o submarino j\u00E1 esta no n\u00EDvel do mar";
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
				throw new RuntimeException(COORDENADA_NVALIDA_O_SUBMARINO_ESTA_NO_NIVEL_DO_MAR);
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
