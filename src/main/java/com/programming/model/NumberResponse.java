package com.programming.model;

public class NumberResponse {

  private String responseWord;

  private String status;

  public NumberResponse(String responseWord, String status) {
    this.responseWord = responseWord;
    this.status = status;
  }

  public String getResponseWord() {
    return responseWord;
  }

  public void setResponseWord(String responseWord) {
    this.responseWord = responseWord;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
