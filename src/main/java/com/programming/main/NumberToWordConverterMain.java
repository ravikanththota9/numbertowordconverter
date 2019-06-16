package com.programming.main;

import com.programming.constants.NumberToWordConverterConstants;
import com.programming.converter.NumberToWordConverter;
import com.programming.converter.NumberToWordConverterImpl;
import com.programming.model.NumberRequest;
import com.programming.model.NumberResponse;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberToWordConverterMain {

   NumberToWordConverterMain(){
    JFrame f=new JFrame("Number to Word Converter");
    //submit button
    JButton b=new JButton("Submit");
    b.setBounds(100,100,140, 40);
    //enter number label
    JLabel label = new JLabel();
    label.setText("Enter Number :");
    label.setBounds(10, 10, 100, 100);
    //empty label which will show event after button clicked
    final JLabel label1 = new JLabel();
    label1.setBounds(2, 110, 500, 100);
    //textfield to enter number
    final JTextField textfield= new JTextField();
    textfield.setBounds(110, 50, 130, 30);
    //add to frame
    f.add(label1);
    f.add(textfield);
    f.add(label);
    f.add(b);
    f.setSize(600,300);
    f.setLayout(null);
    f.setVisible(true);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  b.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      String inputRequest = textfield.getText();
      NumberRequest numberRequest = new NumberRequest(inputRequest);
      NumberToWordConverter numberToWordConverter = new NumberToWordConverterImpl();
      NumberResponse numberResponse = numberToWordConverter.convertNumberToWord(numberRequest);
      String response = formResponse(numberResponse);
      label1.setText(response);
    }
  });
  }

  private String formResponse(NumberResponse numberResponse) {
     if(NumberToWordConverterConstants.success.equalsIgnoreCase(numberResponse.getStatus())){
       StringBuffer stringBuffer = new StringBuffer();
       stringBuffer.append("<html>");
       stringBuffer.append("<font color=\"blue\">"+numberResponse.getResponseWord()+"</font");
       stringBuffer.append("</html>");
       return stringBuffer.toString();
     } else if(NumberToWordConverterConstants.failed.equalsIgnoreCase(numberResponse.getStatus())) {
       StringBuffer stringBuffer = new StringBuffer();
       stringBuffer.append("<html>");
       stringBuffer.append("<font color=\"red\">"+numberResponse.getResponseWord()+"</font");
       stringBuffer.append("</html>");
       return stringBuffer.toString();
     } else {
       StringBuffer stringBuffer = new StringBuffer();
       stringBuffer.append("<html>");
       stringBuffer.append("<font color=\"red\">"+"Unable to fetch response . Please check"+"</font");
       stringBuffer.append("</html>");
       return stringBuffer.toString();
     }
  }

  public static void main(String[] args) {
    new NumberToWordConverterMain();
  }
}
