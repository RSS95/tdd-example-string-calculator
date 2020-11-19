package in.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

  public static void main(String[] args) {
    String input = "";
    StringCalculator stringCalculator = new StringCalculator();
    int sum = stringCalculator.add(input);
    System.out.println("Input : " + input + " :: Sum : " + sum);
  }

  public int add(String numberList) {
    int sum = 0;
    try {
      if ((numberList == null) || (numberList.length() == 0)) {
        throw new Exception();
      }
      List<Character> delimiterList = new ArrayList<>();
      delimiterList.add(',');
      delimiterList.add('\n');

      if (numberList.contains("//")) {
        delimiterList.add(numberList.split("\n")[0].charAt(2));
        numberList = numberList.split("\n")[1];
      }

      StringBuilder lastDigit = new StringBuilder();
      for (int i = 0; i < numberList.length(); i++) {
        if (delimiterList.contains(numberList.charAt(i))) {
          if (lastDigit.length() > 0) {
            sum = sum + Integer.parseInt(lastDigit.toString());
            lastDigit = new StringBuilder();
            continue;
          } else {
            throw new Exception();
          }
        }
        lastDigit.append(numberList.charAt(i));
      }
      if (lastDigit.length() > 0) {
        sum = sum + Integer.parseInt(lastDigit.toString());
      }
    } catch (Exception e) {
      sum = 0;
    }
    return sum;
  }
}
