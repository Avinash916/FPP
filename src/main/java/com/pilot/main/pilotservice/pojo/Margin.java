package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.pilot.main.pilotservice.util.CustomerPricingUtil;

public class Margin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8164962658108108643L;

	private BigDecimal header;

	private BigDecimal vsTgLeft;
	
	private Boolean vsTgLeftPositive;
	
	private BigDecimal vsTgRight;
	
	private BigDecimal vsLyLeft;
	
	private Boolean vsLyLeftPositive;
	
	private BigDecimal vsLyRight;

	public BigDecimal getHeader() {
		return header;
	}

	public void setHeader(BigDecimal header) {
		this.header = CustomerPricingUtil.formatMillionNumbers(header);
	}

	public BigDecimal getVsTgLeft() {
		return vsTgLeft;
	}

	public void setVsTgLeft(BigDecimal vsTgLeft) {
		this.vsTgLeft = CustomerPricingUtil.formatMillionNumbers(vsTgLeft);
	}

	public Boolean getVsTgLeftPositive() {
		return vsTgLeftPositive;
	}

	public void setVsTgLeftPositive(Boolean vsTgLeftPositive) {
		this.vsTgLeftPositive = vsTgLeftPositive;
	}

	public BigDecimal getVsTgRight() {
		return vsTgRight;
	}

	public void setVsTgRight(BigDecimal vsTgRight) {
		this.vsTgRight = CustomerPricingUtil.formatMillionNumbers(vsTgRight);
	}

	public BigDecimal getVsLyLeft() {
		return vsLyLeft;
	}

	public void setVsLyLeft(BigDecimal vsLyLeft) {
		this.vsLyLeft = CustomerPricingUtil.formatMillionNumbers(vsLyLeft);
	}

	public Boolean getVsLyLeftPositive() {
		return vsLyLeftPositive;
	}

	public void setVsLyLeftPositive(Boolean vsLyLeftPositive) {
		this.vsLyLeftPositive = vsLyLeftPositive;
	}

	public BigDecimal getVsLyRight() {
		return vsLyRight;
	}

	public void setVsLyRight(BigDecimal vsLyRight) {
		this.vsLyRight = CustomerPricingUtil.formatMillionNumbers(vsLyRight);
	}

	@Override
	public String toString() {
		return "Margin [header=" + header + ", vsTgLeft=" + vsTgLeft + ", vsTgLeftPositive=" + vsTgLeftPositive
				+ ", vsTgRight=" + vsTgRight + ", vsLyLeft=" + vsLyLeft + ", vsLyLeftPositive=" + vsLyLeftPositive
				+ ", vsLyRight=" + vsLyRight + "]";
	}
}