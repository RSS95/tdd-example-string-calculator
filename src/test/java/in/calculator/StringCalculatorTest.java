package in.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  @Test
  @DisplayName("Test 1 - empty string input")
  void testAdd1() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "";
    int expected = 0;

    int actual = stringCalculator.add(input);

    System.out.print("Test 1 - empty string input ::: ");
    System.out.println("Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 2 - input 1 number")
  void testAdd2() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "0";
    int expected = 0;

    int actual = stringCalculator.add(input);

    System.out.print("Test 2 - input 1 number ::: ");
    System.out.println("Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 3 - input 1 number")
  void testAdd3() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "1";
    int expected = 1;

    int actual = stringCalculator.add(input);

    System.out.print("Test 3 - input 1 number ::: ");
    System.out.println("Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 4 - input 2 number")
  void testAdd4() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "1,2";
    int expected = 3;

    int actual = stringCalculator.add(input);

    System.out.print("Test 4 - input 2 number ::: ");
    System.out.println("Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 5 - null input")
  void testAdd5() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = null;
    int expected = 0;

    int actual = stringCalculator.add(input);

    System.out.print("Test 5 - null input ::: ");
    System.out.println("Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }
}