package br.com.rrc.explore.beans.enums;

import br.com.rrc.explore.beans.Coordenada;

/**
 *  Enum para indicar os pontos cardiais 
 * 
 *  Pontos cardeais: Norte (N), Sul (S), Leste (E) e Oeste (W)
 *  
 *  Desmostração de rosa dos ventos:
 *  
 *  		 Norte (N)
 *  			|
 *  Oeste (W)---|---Leste (E)
 *  			|	
 *  		 Sul (S)  
 * 
 * @author rodrigo
 *
 */
public enum Direcao {
	
	NORTE {
		@Override
		public void navegar(Coordenada coordenada) {
			coordenada.incrementaLongitude();
		}
	},
	SUL {
		@Override
		public void navegar(Coordenada coordenada) {
			coordenada.decrementaLongitude();
		}
	},
	LESTE {
		@Override
		public void navegar(Coordenada coordenada) {
			coordenada.incrementaLatitude();
		}
	},
	OESTE {
		@Override
		public void navegar(Coordenada coordenada) {
			coordenada.decrementaLatitude();
		}
	};

	/**
	 * Responsavel por realizar a navegacao da sonda
	 * de acordo com as seguintes regras:
	 * 
	 *  Esquerda vira 90 graus;
	 *  Direita vira 90 graus;
	 *  
	 *  Aplicando esta regras a rosas dos ventos {@link Direcao}
	 *  
	 *  Sonda apontando para o NORTE 
	 *  	vira 90 graus a esquerda obter direcao OESTE
	 *      vira 90 graus a direita obter direcao LESTE
	 *  
	 *  Sonda apontando para o LESTE 
	 *  	vira 90 graus a esquerda obter direcao NORTE
	 *      vira 90 graus a direita obter direcao SUL
	 * 
	 *  Sonda apontando para o SUL 
	 *  	vira 90 graus a esquerda obter direcao LESTE
	 *      vira 90 graus a direita obter direcao OESTE
	 *
	 *  Sonda apontando para o OESTE 
	 *  	vira 90 graus a esquerda obter direcao SUL
	 *      vira 90 graus a direita obter direcao NORTE
	 *   
	 **/  
	static {
		NORTE.navegar(Direcao.LESTE, Direcao.OESTE);
		SUL.navegar(Direcao.OESTE, Direcao.LESTE);
		LESTE.navegar(Direcao.SUL, Direcao.NORTE);
		OESTE.navegar(Direcao.NORTE, Direcao.SUL);
	}
	
	private Direcao direita;
	private Direcao esquerda;
	
	public Direcao virarEsqueda() {
		return esquerda;
	}
	
	public Direcao virarDireita() {
		return direita;
	}
	
	public abstract void navegar(Coordenada coordenada);
	
	private void navegar(Direcao direita, Direcao esquerda) {
		this.direita = direita;
		this.esquerda = esquerda;
	}
	
}