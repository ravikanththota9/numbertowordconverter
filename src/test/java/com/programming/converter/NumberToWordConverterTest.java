package com.programming.converter;

import com.programming.constants.NumberToWordConverterConstants;
import com.programming.model.NumberRequest;
import com.programming.model.NumberResponse;
import org.junit.Assert;
import org.junit.Test;

public class NumberToWordConverterTest {

  @Test
  public void testConvertNumberToWord(){
    NumberRequest numberRequest = new NumberRequest("123");
    NumberToWordConverter numberToWordConverter = new NumberToWordConverterImpl();
    NumberResponse response = numberToWordConverter.convertNumberToWord(numberRequest);
    Assert.assertNotNull(response);
    Assert.assertEquals(NumberToWordConverterConstants.success,response.getStatus());
    Assert.assertEquals("one hundred twenty three", response.getResponseWord());
  }

  @Test
  public void testConvertNumberToWordWithOutOfRangeRequest(){
    NumberRequest numberRequest = new NumberRequest("10000000000");
    NumberToWordConverter numberToWordConverter = new NumberToWordConverterImpl();
    NumberResponse response = numberToWordConverter.convertNumberToWord(numberRequest);
    Assert.assertNotNull(response);
    Assert.assertEquals(NumberToWordConverterConstants.failed,response.getStatus());
    Assert.assertEquals(NumberToWordConverterConstants.rangeValidCheckResponse, response.getResponseWord());
  }

  @Test
  public void testConvertNumberToWordWithInvalidRequest(){
    NumberRequest numberRequest = new NumberRequest("123abc");
    NumberToWordConverter numberToWordConverter = new NumberToWordConverterImpl();
    NumberResponse response = numberToWordConverter.convertNumberToWord(numberRequest);
    Assert.assertNotNull(response);
    Assert.assertEquals(NumberToWordConverterConstants.failed,response.getStatus());
    Assert.assertEquals(NumberToWordConverterConstants.numberValidCheckResponse, response.getResponseWord());
  }

  @Test
  public void testConvertNumberToWordWithInvalidDecimalRequest(){
    NumberRequest numberRequest = new NumberRequest("100.231");
    NumberToWordConverter numberToWordConverter = new NumberToWordConverterImpl();
    NumberResponse response = numberToWordConverter.convertNumberToWord(numberRequest);
    Assert.assertNotNull(response);
    Assert.assertEquals(NumberToWordConverterConstants.failed,response.getStatus());
    Assert.assertEquals(NumberToWordConverterConstants.decimalValidCheckResponse, response.getResponseWord());
  }

}
