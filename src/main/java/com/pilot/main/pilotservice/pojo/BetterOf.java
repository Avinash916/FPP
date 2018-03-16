<<<<<<< HEAD
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pilot.main.pilotservice.util.CustomerPricingUtil;

public class BetterOf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5288938022538355542L;

	private GrossProfitDollars grossProfitDollars;

	private Volume volume;

	private Margin margin;

	private MixPercentage mixPercentage;

	private BigDecimal buyingPerfActual;

	private BigDecimal buyingPerfTarget;

	private BigDecimal effPumpFeeActual;

	private BigDecimal effPumpFeeTarget;

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

	public BigDecimal getBuyingPerfActual() {
		return buyingPerfActual;
	}

	public void setBuyingPerfActual(BigDecimal buyingPerfActual) {
		this.buyingPerfActual = CustomerPricingUtil.formatMillionNumbers(buyingPerfActual);
	}

	public BigDecimal getBuyingPerfTarget() {
		return buyingPerfTarget;
	}

	public void setBuyingPerfTarget(BigDecimal buyingPerfTarget) {
		this.buyingPerfTarget = CustomerPricingUtil.formatMillionNumbers(buyingPerfTarget);
	}

	public BigDecimal getEffPumpFeeActual() {
		return effPumpFeeActual;
	}

	public void setEffPumpFeeActual(BigDecimal effPumpFeeActual) {
		this.effPumpFeeActual = CustomerPricingUtil.formatMillionNumbers(effPumpFeeActual);
	}

	public BigDecimal getEffPumpFeeTarget() {
		return effPumpFeeTarget;
	}

	public void setEffPumpFeeTarget(BigDecimal effPumpFeeTarget) {
		this.effPumpFeeTarget = CustomerPricingUtil.formatMillionNumbers(effPumpFeeTarget);
	}

	@Override
	public String toString() {
		return "BetterOf [grossProfitDollars=" + grossProfitDollars + ", volume=" + volume + ", margin=" + margin
				+ ", mixPercentage=" + mixPercentage + ", buyingPerfActual=" + buyingPerfActual + ", buyingPerfTarget="
				+ buyingPerfTarget + ", effPumpActual=" + effPumpFeeActual + ", effPumpTarget=" + effPumpFeeTarget + "]";
	}
=======
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;

public class BetterOf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5288938022538355542L;

	private GrossProfitDollars grossProfitDollars;

	private Volume volume;

	private Margin margin;

	private MixPercentage mixPercentage;

	private String buyingPerfActual;

	private String buyingPerfTarget;

	private String effPumpFeeActual;

	private String effPumpFeeTarget;

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

	public String getBuyingPerfActual() {
		return buyingPerfActual;
	}

	public void setBuyingPerfActual(String buyingPerfActual) {
		this.buyingPerfActual = buyingPerfActual;
	}

	public String getBuyingPerfTarget() {
		return buyingPerfTarget;
	}

	public void setBuyingPerfTarget(String buyingPerfTarget) {
		this.buyingPerfTarget = buyingPerfTarget;
	}

	public String getEffPumpFeeActual() {
		return effPumpFeeActual;
	}

	public void setEffPumpFeeActual(String effPumpFeeActual) {
		this.effPumpFeeActual = effPumpFeeActual;
	}

	public String getEffPumpFeeTarget() {
		return effPumpFeeTarget;
	}

	public void setEffPumpFeeTarget(String effPumpFeeTarget) {
		this.effPumpFeeTarget = effPumpFeeTarget;
	}

	@Override
	public String toString() {
		return "BetterOf [grossProfitDollars=" + grossProfitDollars + ", volume=" + volume + ", margin=" + margin
				+ ", mixPercentage=" + mixPercentage + ", buyingPerfActual=" + buyingPerfActual + ", buyingPerfTarget="
				+ buyingPerfTarget + ", effPumpFeeActual=" + effPumpFeeActual + ", effPumpFeeTarget=" + effPumpFeeTarget
				+ "]";
	}
>>>>>>> ssointegration
}