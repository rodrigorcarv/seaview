package br.com.rrc.explore.exceptions;

import br.com.rrc.explore.beans.Coordenada;

public class PosicaoSubimarinoInvalidaException extends RuntimeException{
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	

	private static final String MSG_ERR0_COMANDO_INFORMADO_RESULTARAM_EM_UMA_COORDENADA_INVALDIA = 
			"Os comandos informados levam o submarino para uma coordena %s inv\u00E1lida";
	
	public PosicaoSubimarinoInvalidaException(Coordenada coordenada) {
		super (String.format(MSG_ERR0_COMANDO_INFORMADO_RESULTARAM_EM_UMA_COORDENADA_INVALDIA , coordenada));
	}
}
