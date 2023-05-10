package it.polito.tdp.extflightdelays.model;

import java.util.Objects;

public class Distanza {
	
	private Airport partenza;
	private Airport arrivo;
	private int distanza;
	
	
	public Distanza(Airport partenza, Airport arrivo, int distanza) {
		super();
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.distanza = distanza;
	}


	public Airport getPartenza() {
		return partenza;
	}


	public void setPartenza(Airport partenza) {
		this.partenza = partenza;
	}


	public Airport getArrivo() {
		return arrivo;
	}


	public void setArrivo(Airport arrivo) {
		this.arrivo = arrivo;
	}


	public int getDistanza() {
		return distanza;
	}


	public void setDistanza(int distanza) {
		this.distanza = distanza;
	}


	@Override
	public int hashCode() {
		return Objects.hash(arrivo, distanza, partenza);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distanza other = (Distanza) obj;
		return Objects.equals(arrivo, other.arrivo) && distanza == other.distanza
				&& Objects.equals(partenza, other.partenza);
	}


	@Override
	public String toString() {
		return "Distanza [partenza=" + partenza + ", arrivo=" + arrivo + ", distanza=" + distanza + "]";
	}
	
	

}
