package com.pilot.main.pilotservice.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PFJOverviewUtil {

	public static BigDecimal formatMillionNumbers(BigDecimal number) {
		number = number.divide(BigDecimal.valueOf(1000000), 3, RoundingMode.HALF_UP);
		int precision = number.precision();
		int scale = number.scale();
		if (scale == 0 || precision == 0) {
			return number;
		} else if (scale > precision) {
			return number;
		} else {
			int newScale = precision - scale - 1; // 1 is the decimal point character
			number = number.setScale(newScale, RoundingMode.HALF_UP);
		}
		return number;
	}
}