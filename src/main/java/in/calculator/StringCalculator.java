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

      List<String> delimiterList = new ArrayList<>();
      delimiterList.add(",");
      delimiterList.add("\n");

      if (numberList.contains("//")) {
        String dLine = numberList.split("\\n")[0];
        dLine = dLine.replaceFirst("//", "");
        StringBuilder dl = new StringBuilder();
        for (int i = 0; i < dLine.length(); i++) {
          if (dLine.charAt(i) == '[') {
            continue;
          }
          if (dLine.charAt(i) == ']') {
            delimiterList.add(dl.toString());
            dl = new StringBuilder();
            continue;
          }
          dl.append(dLine.charAt(i));
        }
        numberList = numberList.split("\\n")[1];
      }

      StringBuilder lastDigit = new StringBuilder();
      for (int i = 0; i < numberList.length(); i++) {
        String delimiter = checkContains(delimiterList, numberList, i);
        if (delimiter != null) {
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
            i = i + delimiter.length() - 1;
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
    } catch (NumberFormatException e) {
      sum = 0;
    } catch (RuntimeException e) {
      System.out.println("negatives not allowed :: " + negative.toString());
      sum = Integer.parseInt(negative.get(negative.size() - 1));
    } catch (Exception e) {
      sum = 0;
    }
    return sum;
  }

  private String checkContains(List<String> delimiterList, String numberList, int index) {
    for (String delimiter : delimiterList) {
      if (numberList.length() > index + delimiter.length()
              && numberList.startsWith(delimiter, index)) {
        return delimiter;
      }
    }
    return null;
  }
}
