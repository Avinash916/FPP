<<<<<<< HEAD
<<<<<<< HEAD
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MixPercentage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3958241561608578208L;

	private BigDecimal mixActual;
	
	private BigDecimal mixTarget;
	
	private BigDecimal mixVsLy;
	
	private Boolean mixVsLyPositive;

	public BigDecimal getMixActual() {
		return mixActual;
	}

	public void setMixActual(BigDecimal mixActual) {
		this.mixActual = mixActual.divide(BigDecimal.valueOf(1000000), 2, RoundingMode.HALF_UP);
	}

	public BigDecimal getMixTarget() {
		return mixTarget;
	}

	public void setMixTarget(BigDecimal mixTarget) {
		this.mixTarget = mixTarget.divide(BigDecimal.valueOf(1000000), 2, RoundingMode.HALF_UP);
	}

	public BigDecimal getMixVsLy() {
		return mixVsLy;
	}

	public void setMixVsLy(BigDecimal mixVsLy) {
		this.mixVsLy = mixVsLy.divide(BigDecimal.valueOf(1000000), 2, RoundingMode.HALF_UP);
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
=======
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
=======
package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1

public class MixPercentage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3958241561608578208L;

<<<<<<< HEAD
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
=======
	private BigDecimal mixActual;
	
	private BigDecimal mixTarget;
	
	private BigDecimal mixVsLy;
	
	private Boolean mixVsLyPositive;

	public BigDecimal getMixActual() {
		return mixActual;
	}

	public void setMixActual(BigDecimal mixActual) {
		this.mixActual = mixActual.divide(BigDecimal.valueOf(1000000), 2, RoundingMode.HALF_UP);
	}

	public BigDecimal getMixTarget() {
		return mixTarget;
	}

	public void setMixTarget(BigDecimal mixTarget) {
		this.mixTarget = mixTarget.divide(BigDecimal.valueOf(1000000), 2, RoundingMode.HALF_UP);
	}

	public BigDecimal getMixVsLy() {
		return mixVsLy;
	}

	public void setMixVsLy(BigDecimal mixVsLy) {
		this.mixVsLy = mixVsLy.divide(BigDecimal.valueOf(1000000), 2, RoundingMode.HALF_UP);
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
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
<<<<<<< HEAD
>>>>>>> ssointegration
=======
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
}