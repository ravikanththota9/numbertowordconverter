package com.programming.converter;

import com.programming.constants.NumberToWordConverterConstants;
import com.programming.model.NumberRequest;
import com.programming.model.NumberResponse;

public class NumberToWordConverterImpl implements NumberToWordConverter {

  public NumberResponse convertNumberToWord(NumberRequest numberRequest) {
    NumberResponse numberResponse = null;
    try {
      if(!checkIfNumberContainsDecimals(numberRequest.getRequestNumber())){
        return new NumberResponse(NumberToWordConverterConstants.decimalValidCheckResponse,NumberToWordConverterConstants.failed);
      }
      Long number = Long.parseLong(numberRequest.getRequestNumber());
      if(!checkRangeOfNumber(number)) {
        return new NumberResponse(NumberToWordConverterConstants.rangeValidCheckResponse,NumberToWordConverterConstants.failed);
      }
      String responseWord = convert(number);
      return new NumberResponse(responseWord,NumberToWordConverterConstants.success);
    }catch(Exception e) {
      System.out.println("Exception occurred while parsing request number . Please provide valid number " + e);
      return new NumberResponse(NumberToWordConverterConstants.numberValidCheckResponse,NumberToWordConverterConstants.failed);
    }
  }

  private boolean checkIfNumberContainsDecimals(String requestNumber) {
    if(requestNumber.contains(".")){
      return false;
    }
    return true;
  }

  private boolean checkRangeOfNumber(Long number) {
    if(number<0 || number>999999999){
      return false;
    }
    return true;
  }

  private String convert(Long n) {

    if (n < 20) {
      return NumberToWordConverterConstants.units[n.intValue()];
    }

    if (n < 100) {
      return NumberToWordConverterConstants.tens[n.intValue() / 10] + ((n % 10 != 0) ? " " : "") + NumberToWordConverterConstants.units[n.intValue() % 10];
    }

    if (n < 1000) {
      return NumberToWordConverterConstants.units[n.intValue() / 100] + " hundred" + ((n % 100 != 0) ? " " : "")  + convert(n % 100);
    }

    if (n < 1000000) {
      return convert(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "")  + convert(n % 1000);
    }

    if (n < 1000000000) {
      return convert(n / 1000000) + " million" + ((n % 1000000 != 0) ? " " : "")  + convert(n % 1000000);
    }

    return convert(n / 1000000000) + " billion"  + ((n % 1000000000 != 0) ? " " : "")  + convert(n % 1000000000);
  }

}
