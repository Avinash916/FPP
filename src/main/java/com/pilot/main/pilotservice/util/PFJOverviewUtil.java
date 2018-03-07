package com.pilot.main.pilotservice.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PFJOverviewUtil {

	private static final Logger logger = LoggerFactory.getLogger(PFJOverviewUtil.class);

	public static BigDecimal formatWithMillion(BigDecimal number) {
		logger.debug("Original value of number  ---> " + number);
		number = number.divide(BigDecimal.valueOf(1000000), 4, RoundingMode.HALF_UP);
		logger.debug("After divison with a million to 3rd decimal point  ---> " + number);
		int precision = number.precision();
		int scale = number.scale();
		logger.debug("Found precision  ---> " + precision + " and scale ---> " + scale);
		if (scale == 0 || precision == 0) {
			if (scale == 0 && precision != 0) {
				return number;
			} else if (scale != 0 && precision == 0) {
				return number;
			} else {
				return number;
			}
		} else if (scale > precision) {
			number = number.setScale(4, RoundingMode.HALF_UP);
		} else if (scale == precision) {
			number = number.setScale(3, RoundingMode.HALF_UP);
		} else {
			int newScale = (precision - scale) + 1; // 1 is the decimal point character
			logger.debug("Found (precision - scale) + 1  ---> " + newScale);
			number = number.setScale(newScale, RoundingMode.HALF_UP);
			logger.debug("New value of number after shifting the scale  ---> " + number);
		}
		return number;
	}

	public static BigDecimal formatWithoutMillion(BigDecimal number) {
		int precision = number.precision();
		int scale = number.scale();
		logger.debug("Found precision  ---> " + precision + " and scale ---> " + scale);
		if (scale == 0 || precision == 0) {
			if (scale == 0 && precision != 0) {
				return number;
			} else if (scale != 0 && precision == 0) {
				return number;
			} else {
				return number;
			}
		} else if (scale > precision) {
			number = number.setScale(4, RoundingMode.HALF_UP);
		} else if (scale == precision) {
			number = number.setScale(3, RoundingMode.HALF_UP);
		} else {
			int newScale = (precision - scale) + 1; // 1 is the decimal point character
			logger.debug("Found (precision - scale) + 1  ---> " + newScale);
			number = number.setScale(newScale, RoundingMode.HALF_UP);
			logger.debug("New value of number after shifting the scale  ---> " + number);
		}
		return number;
	}
}