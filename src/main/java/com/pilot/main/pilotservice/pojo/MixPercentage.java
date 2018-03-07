package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;

public class MixPercentage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3958241561608578208L;

	private String mixActual;
	
	private String mixTarget;
	
	private String mixVsLy;
	
	private Boolean mixVsLyPositive;

	public String getMixActual() {
		return mixActual;
	}

	public void setMixActual(String mixActual) {
		this.mixActual = mixActual;
	}

	public String getMixTarget() {
		return mixTarget;
	}

	public void setMixTarget(String mixTarget) {
		this.mixTarget = mixTarget;
	}

	public String getMixVsLy() {
		return mixVsLy;
	}

	public void setMixVsLy(String mixVsLy) {
		this.mixVsLy = mixVsLy;
	}

	public Boolean getMixVsLyPositive() {
		return mixVsLyPositive;
	}

	public void setMixVsLyPositive(Boolean mixVsLyPositive) {
		this.mixVsLyPositive = mixVsLyPositive;
	}

	@Override
	public String toString() {
		return "MixPercentage [mixActual=" + mixActual + ", mixTarget=" + mixTarget + ", mixVsLy=" + mixVsLy
				+ ", mixVsLyPositive=" + mixVsLyPositive + "]";
	}
}