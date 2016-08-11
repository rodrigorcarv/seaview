package br.com.rrc.explore.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Coordenada {

	private int latitude;
	private int longitude;
	private int altitude;
	
	public Coordenada(int latitude, int longitude, int altitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}
	
	public int getLatitude() {
		return latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public int getAltitude() {
		return altitude;
	}
	
	public void incrementaLongitude() {
		++longitude;
	}

	public void decrementaLongitude() {
		--longitude;
	}

	public void incrementaLatitude() {
		++latitude;
	}

	public void decrementaLatitude() {
		--latitude;
	}
	
	public void incrementaAltitude() {
		++altitude;
	}
	
	public void decrementaAltitude() {
		--altitude;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
