package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pilot.main.pilotservice.util.PFJOverviewUtil;

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
		this.header = PFJOverviewUtil.formatMillionNumbers(header);
	}

	public BigDecimal getVsTgLeft() {
		return vsTgLeft;
	}

	public void setVsTgLeft(BigDecimal vsTgLeft) {
		this.vsTgLeft = PFJOverviewUtil.formatMillionNumbers(vsTgLeft);
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
		this.vsTgRight = PFJOverviewUtil.formatMillionNumbers(vsTgRight);
	}

	public BigDecimal getVsLyLeft() {
		return vsLyLeft;
	}

	public void setVsLyLeft(BigDecimal vsLyLeft) {
		this.vsLyLeft = PFJOverviewUtil.formatMillionNumbers(vsLyLeft);
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
		this.vsLyRight = PFJOverviewUtil.formatMillionNumbers(vsLyRight);
	}

	@Override
	public String toString() {
		return "Margin [header=" + header + ", vsTgLeft=" + vsTgLeft + ", vsTgLeftPositive=" + vsTgLeftPositive
				+ ", vsTgRight=" + vsTgRight + ", vsLyLeft=" + vsLyLeft + ", vsLyLeftPositive=" + vsLyLeftPositive
				+ ", vsLyRight=" + vsLyRight + "]";
	}
}