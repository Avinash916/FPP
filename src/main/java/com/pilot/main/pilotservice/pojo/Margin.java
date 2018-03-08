package com.pilot.main.pilotservice.pojo;

import java.io.Serializable;

public class Margin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8164962658108108643L;

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
	}

	public Boolean getVsTgLeftPositive() {
		return vsTgLeftPositive;
	}

	public void setVsTgLeftPositive(Boolean vsTgLeftPositive) {
		this.vsTgLeftPositive = vsTgLeftPositive;
	}

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
	}

	public Boolean getVsLyLeftPositive() {
		return vsLyLeftPositive;
	}

	public void setVsLyLeftPositive(Boolean vsLyLeftPositive) {
		this.vsLyLeftPositive = vsLyLeftPositive;
	}

	public String getVsLyRight() {
		return vsLyRight;
	}

	public void setVsLyRight(String vsLyRight) {
		this.vsLyRight = vsLyRight;
	}

	@Override
	public String toString() {
		return "Margin [header=" + header + ", vsTgLeft=" + vsTgLeft + ", vsTgLeftPositive=" + vsTgLeftPositive
				+ ", vsTgRight=" + vsTgRight + ", vsLyLeft=" + vsLyLeft + ", vsLyLeftPositive=" + vsLyLeftPositive
				+ ", vsLyRight=" + vsLyRight + "]";
	}
}