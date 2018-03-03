package com.pilot.main.pilotrepo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FCT_DM_COMPANY_LEVEL_ACTUAL_VS_TARGET", schema = "fpp_dev")
public class FctDmCompanyLevelActualVsTargetEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3297714067201050200L;

	@EmbeddedId
	FctDmCompanyLevelActualVsTargetId fctDmCompanyLevelActualVsTargetId;

	@Column(name = "DIM_CURRENCY_ID")
	private Long dimCurrencyId;

	@Column(name = "DIM_QUANTITY_CONVERSION_ID")
	private Long dimQuantityConversionId;

	@Column(name = "ACTUAL_PROFIT_NET_OF_DISCOUNTS")
	private BigDecimal actualProfitNetOfDiscounts;

	@Column(name = "ACTUAL_PROFIT_NET_OF_DISCOUNTS_LY")
	private BigDecimal actualProfitNetOfDiscountsLy;

	@Column(name = "TARGET_PROFIT_NET_OF_DISCOUNTS")
	private BigDecimal targetProfitNetOfDiscounts;

	@Column(name = "ACTUAL_VOLUME")
	private BigDecimal actualVolume;

	@Column(name = "ACTUAL_VOLUME_LY")
	private BigDecimal actualVolumeLy;

	@Column(name = "TARGET_VOLUME")
	private BigDecimal targetVolume;

	@Column(name = "ACTUAL_BUYING_PERFORMANCE")
	private BigDecimal actualBuyingPerformance;

	@Column(name = "TARGET_BUYING_PERFORMANCE")
	private BigDecimal targetBuyingPerformance;

	@Column(name = "ACTUAL_EFFECTIVE_PUMP_FEE")
	private BigDecimal actualEffectivePumpFee;

	@Column(name = "TARGET_EFFECTIVE_PUMP_FEE")
	private BigDecimal targetEffectivePumpFee;

	@Column(name = "ACTUAL_MARGIN_NET_OF_DISCOUNTS")
	private BigDecimal actualMarginNetOfDiscounts;

	@Column(name = "ACTUAL_MARGIN_NET_OF_DISCOUNTS_Ly")
	private BigDecimal actualMarginNetOfDiscountsLy;

	@Column(name = "TARGET_MARGIN_NET_OF_DISCOUNTS")
	private BigDecimal targetMarginNetOfDiscounts;
	
	@Column(name = "ACTUAL_EFFECTIVE_RETAIL_MINUS_RATE")
	private BigDecimal actualEffectiveRetailMinusRate;
	
	@Column(name = "TARGET_EFFECTIVE_RETAIL_MINUS_RATE")
	private BigDecimal targetEffectiveRetailMinusRate;
	
	@Column(name = "DIM_PL_PERIOD_DATE_ID")
	private Integer dimPlPeriodDateId;

	public FctDmCompanyLevelActualVsTargetId getFctDmCompanyLevelActualVsTargetId() {
		return fctDmCompanyLevelActualVsTargetId;
	}

	public void setFctDmCompanyLevelActualVsTargetId(FctDmCompanyLevelActualVsTargetId fctDmCompanyLevelActualVsTargetId) {
		this.fctDmCompanyLevelActualVsTargetId = fctDmCompanyLevelActualVsTargetId;
	}

	public Long getDimCurrencyId() {
		return dimCurrencyId;
	}

	public void setDimCurrencyId(Long dimCurrencyId) {
		this.dimCurrencyId = dimCurrencyId;
	}

	public Long getDimQuantityConversionId() {
		return dimQuantityConversionId;
	}

	public void setDimQuantityConversionId(Long dimQuantityConversionId) {
		this.dimQuantityConversionId = dimQuantityConversionId;
	}

	public BigDecimal getActualProfitNetOfDiscounts() {
		return actualProfitNetOfDiscounts;
	}

	public void setActualProfitNetOfDiscounts(BigDecimal actualProfitNetOfDiscounts) {
		this.actualProfitNetOfDiscounts = actualProfitNetOfDiscounts;
	}

	public BigDecimal getActualProfitNetOfDiscountsLy() {
		return actualProfitNetOfDiscountsLy;
	}

	public void setActualProfitNetOfDiscountsLy(BigDecimal actualProfitNetOfDiscountsLy) {
		this.actualProfitNetOfDiscountsLy = actualProfitNetOfDiscountsLy;
	}

	public BigDecimal getTargetProfitNetOfDiscounts() {
		return targetProfitNetOfDiscounts;
	}

	public void setTargetProfitNetOfDiscounts(BigDecimal targetProfitNetOfDiscounts) {
		this.targetProfitNetOfDiscounts = targetProfitNetOfDiscounts;
	}

	public BigDecimal getActualVolume() {
		return actualVolume;
	}

	public void setActualVolume(BigDecimal actualVolume) {
		this.actualVolume = actualVolume;
	}

	public BigDecimal getActualVolumeLy() {
		return actualVolumeLy;
	}

	public void setActualVolumeLy(BigDecimal actualVolumeLy) {
		this.actualVolumeLy = actualVolumeLy;
	}

	public BigDecimal getTargetVolume() {
		return targetVolume;
	}

	public void setTargetVolume(BigDecimal targetVolume) {
		this.targetVolume = targetVolume;
	}

	public BigDecimal getActualBuyingPerformance() {
		return actualBuyingPerformance;
	}

	public void setActualBuyingPerformance(BigDecimal actualBuyingPerformance) {
		this.actualBuyingPerformance = actualBuyingPerformance;
	}

	public BigDecimal getTargetBuyingPerformance() {
		return targetBuyingPerformance;
	}

	public void setTargetBuyingPerformance(BigDecimal targetBuyingPerformance) {
		this.targetBuyingPerformance = targetBuyingPerformance;
	}

	public BigDecimal getActualEffectivePumpFee() {
		return actualEffectivePumpFee;
	}

	public void setActualEffectivePumpFee(BigDecimal actualEffectivePumpFee) {
		this.actualEffectivePumpFee = actualEffectivePumpFee;
	}

	public BigDecimal getTargetEffectivePumpFee() {
		return targetEffectivePumpFee;
	}

	public void setTargetEffectivePumpFee(BigDecimal targetEffectivePumpFee) {
		this.targetEffectivePumpFee = targetEffectivePumpFee;
	}

	public BigDecimal getActualMarginNetOfDiscounts() {
		return actualMarginNetOfDiscounts;
	}

	public void setActualMarginNetOfDiscounts(BigDecimal actualMarginNetOfDiscounts) {
		this.actualMarginNetOfDiscounts = actualMarginNetOfDiscounts;
	}

	public BigDecimal getActualMarginNetOfDiscountsLy() {
		return actualMarginNetOfDiscountsLy;
	}

	public void setActualMarginNetOfDiscountsLy(BigDecimal actualMarginNetOfDiscountsLy) {
		this.actualMarginNetOfDiscountsLy = actualMarginNetOfDiscountsLy;
	}

	public BigDecimal getTargetMarginNetOfDiscounts() {
		return targetMarginNetOfDiscounts;
	}

	public void setTargetMarginNetOfDiscounts(BigDecimal targetMarginNetOfDiscounts) {
		this.targetMarginNetOfDiscounts = targetMarginNetOfDiscounts;
	}

	public BigDecimal getActualEffectiveRetailMinusRate() {
		return actualEffectiveRetailMinusRate;
	}

	public void setActualEffectiveRetailMinusRate(BigDecimal actualEffectiveRetailMinusRate) {
		this.actualEffectiveRetailMinusRate = actualEffectiveRetailMinusRate;
	}

	public BigDecimal getTargetEffectiveRetailMinusRate() {
		return targetEffectiveRetailMinusRate;
	}

	public void setTargetEffectiveRetailMinusRate(BigDecimal targetEffectiveRetailMinusRate) {
		this.targetEffectiveRetailMinusRate = targetEffectiveRetailMinusRate;
	}

	public Integer getDimPlPeriodDateId() {
		return dimPlPeriodDateId;
	}

	public void setDimPlPeriodDateId(Integer dimPlPeriodDateId) {
		this.dimPlPeriodDateId = dimPlPeriodDateId;
	}

	@Override
	public String toString() {
		return "FctDmCompanyLevelActualVsTargetEntity [fctDmCompanyLevelActualVsTargetId="
				+ fctDmCompanyLevelActualVsTargetId + ", dimCurrencyId=" + dimCurrencyId + ", dimQuantityConversionId="
				+ dimQuantityConversionId + ", actualProfitNetOfDiscounts=" + actualProfitNetOfDiscounts
				+ ", actualProfitNetOfDiscountsLy=" + actualProfitNetOfDiscountsLy + ", targetProfitNetOfDiscounts="
				+ targetProfitNetOfDiscounts + ", actualVolume=" + actualVolume + ", actualVolumeLy=" + actualVolumeLy
				+ ", targetVolume=" + targetVolume + ", actualBuyingPerformance=" + actualBuyingPerformance
				+ ", targetBuyingPerformance=" + targetBuyingPerformance + ", actualEffectivePumpFee="
				+ actualEffectivePumpFee + ", targetEffectivePumpFee=" + targetEffectivePumpFee
				+ ", actualMarginNetOfDiscounts=" + actualMarginNetOfDiscounts + ", actualMarginNetOfDiscountsLy="
				+ actualMarginNetOfDiscountsLy + ", targetMarginNetOfDiscounts=" + targetMarginNetOfDiscounts
				+ ", actualEffectiveRetailMinusRate=" + actualEffectiveRetailMinusRate
				+ ", targetEffectiveRetailMinusRate=" + targetEffectiveRetailMinusRate + ", dimPlPeriodDateId="
				+ dimPlPeriodDateId + "]";
	}
}
