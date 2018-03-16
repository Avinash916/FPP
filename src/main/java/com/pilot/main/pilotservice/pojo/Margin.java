<<<<<<< HEAD
<<<<<<< HEAD
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
=======
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
=======
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pilot.main.pilotservice.util.PFJOverviewUtil;
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1

public class Margin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8164962658108108643L;

<<<<<<< HEAD
	private String header;

	private String vsTgLeft;
	
	private Boolean vsTgLeftPositive;
	
	private String vsTgRight;
	
	private String vsLyLeft;
	
	private Boolean vsLyLeftPositive;
	
	private String vsLyRight;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getVsTgLeft() {
		return vsTgLeft;
	}

	public void setVsTgLeft(String vsTgLeft) {
		this.vsTgLeft = vsTgLeft;
=======
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
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
	}

	public Boolean getVsTgLeftPositive() {
		return vsTgLeftPositive;
	}

	public void setVsTgLeftPositive(Boolean vsTgLeftPositive) {
		this.vsTgLeftPositive = vsTgLeftPositive;
	}

<<<<<<< HEAD
	public String getVsTgRight() {
		return vsTgRight;
	}

	public void setVsTgRight(String vsTgRight) {
		this.vsTgRight = vsTgRight;
	}

	public String getVsLyLeft() {
		return vsLyLeft;
	}

	public void setVsLyLeft(String vsLyLeft) {
		this.vsLyLeft = vsLyLeft;
=======
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
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
	}

	public Boolean getVsLyLeftPositive() {
		return vsLyLeftPositive;
	}

	public void setVsLyLeftPositive(Boolean vsLyLeftPositive) {
		this.vsLyLeftPositive = vsLyLeftPositive;
	}

<<<<<<< HEAD
	public String getVsLyRight() {
		return vsLyRight;
	}

	public void setVsLyRight(String vsLyRight) {
		this.vsLyRight = vsLyRight;
=======
	public BigDecimal getVsLyRight() {
		return vsLyRight;
	}

	public void setVsLyRight(BigDecimal vsLyRight) {
		this.vsLyRight = PFJOverviewUtil.formatMillionNumbers(vsLyRight);
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
	}

	@Override
	public String toString() {
		return "Margin [header=" + header + ", vsTgLeft=" + vsTgLeft + ", vsTgLeftPositive=" + vsTgLeftPositive
				+ ", vsTgRight=" + vsTgRight + ", vsLyLeft=" + vsLyLeft + ", vsLyLeftPositive=" + vsLyLeftPositive
				+ ", vsLyRight=" + vsLyRight + "]";
	}
<<<<<<< HEAD
>>>>>>> ssointegration
=======
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
}