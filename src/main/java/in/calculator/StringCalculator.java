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

    if ((numberList == null) || (numberList.length() == 0)) {
      return sum;
    }

    String[] numArray = numberList.split(",");

    for (String s : numArray) {
      sum = sum + Integer.parseInt(s);
    }

    return sum;
  }
}
