package com.programming.converter;

import com.programming.model.NumberRequest;
import com.programming.model.NumberResponse;

public interface NumberToWordConverter {

  public NumberResponse convertNumberToWord(NumberRequest numberRequest);

}
