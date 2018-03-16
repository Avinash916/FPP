<<<<<<< HEAD
<<<<<<< HEAD
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pilot.main.pilotservice.util.CustomerPricingUtil;

public class RetailMinus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 917554479786203639L;

	private GrossProfitDollars grossProfitDollars;
	
	private Volume volume;
	
	private Margin margin;
	
	private MixPercentage mixPercentage;
	
	private BigDecimal rmDiscountActual;
	
	private BigDecimal rmDiscountTarget;

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

	public BigDecimal getRmDiscountActual() {
		return rmDiscountActual;
	}

	public void setRmDiscountActual(BigDecimal rmDiscountActual) {
		this.rmDiscountActual = CustomerPricingUtil.formatMillionNumbers(rmDiscountActual);
	}

	public BigDecimal getRmDiscountTarget() {
		return rmDiscountTarget;
	}

	public void setRmDiscountTarget(BigDecimal rmDiscountTarget) {
		this.rmDiscountTarget = CustomerPricingUtil.formatMillionNumbers(rmDiscountTarget);
	}

	@Override
	public String toString() {
		return "RetailMinus [grossProfitDollars=" + grossProfitDollars + ", volume=" + volume + ", margin=" + margin
				+ ", mixPercentage=" + mixPercentage + ", rmDiscountActual=" + rmDiscountActual + ", rmDiscountTarget="
				+ rmDiscountTarget + "]";
	}
=======
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
=======
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pilot.main.pilotservice.util.PFJOverviewUtil;
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1

public class RetailMinus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 917554479786203639L;

	private GrossProfitDollars grossProfitDollars;
	
	private Volume volume;
	
	private Margin margin;
	
	private MixPercentage mixPercentage;
	
<<<<<<< HEAD
	private String rmDiscountActual;
	
	private String rmDiscountTarget;
=======
	private BigDecimal rmDiscountActual;
	
	private BigDecimal rmDiscountTarget;
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1

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

<<<<<<< HEAD
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
=======
	public BigDecimal getRmDiscountActual() {
		return rmDiscountActual;
	}

	public void setRmDiscountActual(BigDecimal rmDiscountActual) {
		this.rmDiscountActual = PFJOverviewUtil.formatMillionNumbers(rmDiscountActual);
	}

	public BigDecimal getRmDiscountTarget() {
		return rmDiscountTarget;
	}

	public void setRmDiscountTarget(BigDecimal rmDiscountTarget) {
		this.rmDiscountTarget = PFJOverviewUtil.formatMillionNumbers(rmDiscountTarget);
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
	}

	@Override
	public String toString() {
		return "RetailMinus [grossProfitDollars=" + grossProfitDollars + ", volume=" + volume + ", margin=" + margin
				+ ", mixPercentage=" + mixPercentage + ", rmDiscountActual=" + rmDiscountActual + ", rmDiscountTarget="
				+ rmDiscountTarget + "]";
	}
<<<<<<< HEAD
>>>>>>> ssointegration
=======
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
}