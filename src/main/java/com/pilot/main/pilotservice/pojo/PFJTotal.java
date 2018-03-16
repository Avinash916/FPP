<<<<<<< HEAD
<<<<<<< HEAD
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pilot.main.pilotservice.util.CustomerPricingUtil;

public class PFJTotal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3422873344242250017L;

	private GrossProfitDollars grossProfitDollars;
	
	private Volume volume;
	
	private Margin margin;
	
	private BigDecimal totalGAL;
	
	private BigDecimal totalTarget;

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

	public BigDecimal getTotalGAL() {
		return totalGAL;
	}

	public void setTotalGAL(BigDecimal totalGAL) {
		this.totalGAL = CustomerPricingUtil.formatMillionNumbers(totalGAL);
	}

	public BigDecimal getTotalTarget() {
		return totalTarget;
	}

	public void setTotalTarget(BigDecimal totalTarget) {
		this.totalTarget = CustomerPricingUtil.formatMillionNumbers(totalTarget);
	}

	@Override
	public String toString() {
		return "PFJTotal [grossProfitDollars=" + grossProfitDollars + ", volume=" + volume + ", margin=" + margin
				+ ", totalGAL=" + totalGAL + ", totalTarget=" + totalTarget + "]";
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

public class PFJTotal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3422873344242250017L;

	private GrossProfitDollars grossProfitDollars;
	
	private Volume volume;
	
	private Margin margin;
	
<<<<<<< HEAD
	private String totalGAL;
	
	private String totalTarget;
=======
	private BigDecimal totalGAL;
	
	private BigDecimal totalTarget;
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

<<<<<<< HEAD
	public String getTotalGAL() {
		return totalGAL;
	}

	public void setTotalGAL(String totalGAL) {
		this.totalGAL = totalGAL;
	}

	public String getTotalTarget() {
		return totalTarget;
	}

	public void setTotalTarget(String totalTarget) {
		this.totalTarget = totalTarget;
=======
	public BigDecimal getTotalGAL() {
		return totalGAL;
	}

	public void setTotalGAL(BigDecimal totalGAL) {
		this.totalGAL = PFJOverviewUtil.formatMillionNumbers(totalGAL);
	}

	public BigDecimal getTotalTarget() {
		return totalTarget;
	}

	public void setTotalTarget(BigDecimal totalTarget) {
		this.totalTarget = PFJOverviewUtil.formatMillionNumbers(totalTarget);
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
	}

	@Override
	public String toString() {
		return "PFJTotal [grossProfitDollars=" + grossProfitDollars + ", volume=" + volume + ", margin=" + margin
				+ ", totalGAL=" + totalGAL + ", totalTarget=" + totalTarget + "]";
	}
<<<<<<< HEAD
>>>>>>> ssointegration
=======
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
}