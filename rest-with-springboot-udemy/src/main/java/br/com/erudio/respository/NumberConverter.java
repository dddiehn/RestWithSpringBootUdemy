package br.com.erudio.respository;

public class NumberConverter {
	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) {
			return Double.parseDouble(number);
		} else {
			return 0D;
		}
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

//	public static void numericArguments(String[] numbers) {
//		for (String number : numbers) {
//			if (!isNumeric(number)) {
//				throw new UnsupportedMathOperationException("Please set a numeric value!");
//			}
//		}
//	}
}
