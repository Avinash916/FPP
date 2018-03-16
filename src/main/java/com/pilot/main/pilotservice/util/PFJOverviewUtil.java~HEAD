package com.pilot.main.pilotservice.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public final class PFJOverviewUtil {

	private static final StringBuilder formatter = new StringBuilder();

	public static final String formatWithMillion(BigDecimal number) {
		number = number.divide(BigDecimal.valueOf(1000000), 5, RoundingMode.HALF_UP);
		return formatWithoutMillion(number);
	}

	public static final String formatWithoutMillion(BigDecimal number) {
		String formatted = null;
		int precision = number.precision();
		int scale = number.scale();
		if (scale > precision) {
			if (number.signum() == 0) {
				number = number.setScale(3, RoundingMode.HALF_UP);
				formatted = number.toString();
			} else {
				// number = number.setScale(4, RoundingMode.HALF_UP);
				formatter.append(number.toString());
				int index = formatter.indexOf(".");
				if ((index + 5) <= (formatter.length() - 1)) {
					formatter.delete(index + 5, formatter.length());
				}
				formatter.deleteCharAt(index - 1);
				formatted = formatter.toString();
			}
		} else if (scale == precision) {
			// number = number.setScale(3, RoundingMode.HALF_UP);
			formatter.append(number.toString());
			int index = formatter.indexOf(".");
			if ((index + 4) <= (formatter.length() - 1)) {
				formatter.delete(index + 4, formatter.length());
			}
			formatted = formatter.toString();
		} else {
			int newScale = 5 - ((precision - scale) + 1); // 1 is the decimal point character
			// number = number.setScale(newScale, RoundingMode.HALF_UP);
			formatter.append(number.toString());
			if (scale == 0) {
				formatter.insert(1, ',');
			} else {
				int index = formatter.indexOf(".");
				if ((index + newScale + 1) <= (formatter.length() - 1)) {
					formatter.delete(index + newScale + 1, formatter.length());
				}
			}
			formatted = formatter.toString();
		}
		formatter.setLength(0);
		return formatted;
	}
}