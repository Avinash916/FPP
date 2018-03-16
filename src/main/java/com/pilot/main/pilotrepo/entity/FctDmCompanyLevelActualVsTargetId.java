<<<<<<< HEAD
<<<<<<< HEAD
package com.pilot.main.pilotrepo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FctDmCompanyLevelActualVsTargetId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5757063939829678731L;

	@Column(name = "DIM_LINE_OF_BUSINESS_GROUP_ID")
	private Long dimLineOfBusinessGroupId;

	@Column(name = "MIX_OF_BUSINESS")
	private String mixOfBusiness;

	@Column(name = "TEMPORAL_PERIOD")
	private String temporalPeriod;

	public Long getDimLineOfBusinessGroupId() {
		return dimLineOfBusinessGroupId;
	}

	public void setDimLineOfBusinessGroupId(Long dimLineOfBusinessGroupId) {
		this.dimLineOfBusinessGroupId = dimLineOfBusinessGroupId;
	}

	public String getMixOfBusiness() {
		return mixOfBusiness;
	}

	public void setMixOfBusiness(String mixOfBusiness) {
		this.mixOfBusiness = mixOfBusiness;
	}

	public String getTemporalPeriod() {
		return temporalPeriod;
	}

	public void setTemporalPeriod(String temporalPeriod) {
		this.temporalPeriod = temporalPeriod;
	}

	@Override
	public String toString() {
		return "FctDmCompanyLevelActualVsTargetId [dimLineOfBusinessGroupId=" + dimLineOfBusinessGroupId
				+ ", mixOfBusiness=" + mixOfBusiness + ", temporalPeriod=" + temporalPeriod + "]";
	}
=======
=======
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
package com.pilot.main.pilotrepo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FctDmCompanyLevelActualVsTargetId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5757063939829678731L;

	@Column(name = "DIM_LINE_OF_BUSINESS_GROUP_ID")
	private Long dimLineOfBusinessGroupId;

	@Column(name = "MIX_OF_BUSINESS")
	private String mixOfBusiness;

	@Column(name = "TEMPORAL_PERIOD")
	private String temporalPeriod;

	public Long getDimLineOfBusinessGroupId() {
		return dimLineOfBusinessGroupId;
	}

	public void setDimLineOfBusinessGroupId(Long dimLineOfBusinessGroupId) {
		this.dimLineOfBusinessGroupId = dimLineOfBusinessGroupId;
	}

	public String getMixOfBusiness() {
		return mixOfBusiness;
	}

	public void setMixOfBusiness(String mixOfBusiness) {
		this.mixOfBusiness = mixOfBusiness;
	}

	public String getTemporalPeriod() {
		return temporalPeriod;
	}

	public void setTemporalPeriod(String temporalPeriod) {
		this.temporalPeriod = temporalPeriod;
	}

	@Override
	public String toString() {
		return "FctDmCompanyLevelActualVsTargetId [dimLineOfBusinessGroupId=" + dimLineOfBusinessGroupId
				+ ", mixOfBusiness=" + mixOfBusiness + ", temporalPeriod=" + temporalPeriod + "]";
	}
<<<<<<< HEAD
>>>>>>> ssointegration
=======
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
}