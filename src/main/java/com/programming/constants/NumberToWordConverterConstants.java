package com.programming.constants;

public class NumberToWordConverterConstants {
  public static final String[] units = {
      "", "one", "two", "three", "four", "five", "six", "seven",
      "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
      "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
  };

  public static final String[] tens = {
      "",        // 0
      "",        // 1
      "twenty",  // 2
      "thirty",  // 3
      "forty",   // 4
      "fifty",   // 5
      "sixty",   // 6
      "seventy", // 7
      "eighty",  // 8
      "ninety"   // 9
  };

  public static final String rangeValidCheckResponse = "Please provide number between 0 to 999999999";

  public static final String success = "success";

  public static final String failed = "failed";

  public static final String numberValidCheckResponse = "Please provide valid number";

  public static final String decimalValidCheckResponse = "Please remove decimal values from number";

}
