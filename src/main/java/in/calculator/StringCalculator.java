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
    List<String> negative = new ArrayList<>();
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
            int num = Integer.parseInt(lastDigit.toString());
            if (num < 0) {
              negative.add(String.valueOf(num));
            }
            if (num > 1000) {
              continue;
            }
            sum = sum + num;
            lastDigit = new StringBuilder();
            continue;
          } else {
            throw new Exception();
          }
        }
        lastDigit.append(numberList.charAt(i));
      }

      if (lastDigit.length() > 0) {
        int num = Integer.parseInt(lastDigit.toString());
        if (num < 0) {
          negative.add(String.valueOf(num));
        }
        if (num < 1000) {
          sum = sum + num;
        }
      }

      if (!negative.isEmpty()) {
        throw new RuntimeException();
      }
    } catch (RuntimeException e) {
      System.out.println("negatives not allowed :: " + negative.toString());
      sum = Integer.parseInt(negative.get(negative.size() - 1));
    } catch (Exception e) {
      sum = 0;
    }
    return sum;
  }
}
