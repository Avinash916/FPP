package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;

public class RetailMinus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 917554479786203639L;

	private GrossProfitDollars grossProfitDollars;
	
	private Volume volume;
	
	private Margin margin;
	
	private MixPercentage mixPercentage;
	
	private String rmDiscountActual;
	
	private String rmDiscountTarget;

	public GrossProfitDollars getGrossProfitDollars() {
		return grossProfitDollars;
	}

	public void setGrossProfitDollars(GrossProfitDollars grossProfitDollars) {
		this.grossProfitDollars = grossProfitDollars;
	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	public Margin getMargin() {
		return margin;
	}

	public void setMargin(Margin margin) {
		this.margin = margin;
	}

	public MixPercentage getMixPercentage() {
		return mixPercentage;
	}

	public void setMixPercentage(MixPercentage mixPercentage) {
		this.mixPercentage = mixPercentage;
	}

	public String getRmDiscountActual() {
		return rmDiscountActual;
	}

	public void setRmDiscountActual(String rmDiscountActual) {
		this.rmDiscountActual = rmDiscountActual;
	}

	public String getRmDiscountTarget() {
		return rmDiscountTarget;
	}

	public void setRmDiscountTarget(String rmDiscountTarget) {
		this.rmDiscountTarget = rmDiscountTarget;
	}

	@Override
	public String toString() {
		return "RetailMinus [grossProfitDollars=" + grossProfitDollars + ", volume=" + volume + ", margin=" + margin
				+ ", mixPercentage=" + mixPercentage + ", rmDiscountActual=" + rmDiscountActual + ", rmDiscountTarget="
				+ rmDiscountTarget + "]";
	}
}