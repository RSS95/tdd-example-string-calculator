package in.calculator;

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
      StringBuilder lastDigit = new StringBuilder();
      for (int i = 0; i < numberList.length(); i++) {
        if (numberList.charAt(i) == ',' || numberList.charAt(i) == '\n') {
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
