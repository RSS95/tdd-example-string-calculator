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
    System.out.println(
            "Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

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
    System.out.println(
            "Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

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
    System.out.println(
            "Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

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
    System.out.println(
            "Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

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
    System.out.println(
            "Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 6 - unknown multiple inputs")
  void testAdd6() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "0,1,2,3,4,5,6,7,8,9";
    int expected = 45;

    int actual = stringCalculator.add(input);

    System.out.print("Test 6 - unknown multiple inputs ::: ");
    System.out.println(
            "Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 7 - positive case for new line instead of ',' as delimiter")
  void testAdd7() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "1\n2,3";
    int expected = 6;

    int actual = stringCalculator.add(input);

    System.out.print("Test 7 - positive case for new line instead of ',' as delimiter ::: ");
    System.out.println("Input : '1\\n2,3' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 8 - negative case for new line instead of ',' as delimiter")
  void testAdd8() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "1,\n";
    int expected = 0;

    int actual = stringCalculator.add(input);

    System.out.print("Test 8 - negative case for new line instead of ',' as delimiter ::: ");
    System.out.println("Input : '1,\\n' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 9 - to change a delimiter")
  void testAdd9() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "//[;]\n1;2";
    int expected = 3;

    int actual = stringCalculator.add(input);

    System.out.print("Test 9 - to change a delimiter ::: ");
    System.out.println(
            "Input : '//[;]\\n1;2' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 10 - negatives not allowed")
  void testAdd10() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "1,-2,-3";
    int expected = -3;

    int actual = stringCalculator.add(input);

    System.out.print("Test 10 - negatives not allowed ::: ");
    System.out.println(
            "Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 11 - Numbers bigger than 1000 should be ignored")
  void testAdd11() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "1,2,3,1001";
    int expected = 6;

    int actual = stringCalculator.add(input);

    System.out.print("Test 11 - Numbers bigger than 1000 should be ignored ::: ");
    System.out.println(
            "Input : '" + input + "' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 12 - Delimiters can be of any length")
  void testAdd12() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "//[***]\n1***2***3";
    int expected = 6;

    int actual = stringCalculator.add(input);

    System.out.print("Test 12 - Delimiters can be of any length ::: ");
    System.out.println(
            "Input : '//[***]\\n1***2***3' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Test 13 - Allow multiple delimiters")
  void testAdd13() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "//[*][%]\n1*2%3";
    int expected = 6;

    int actual = stringCalculator.add(input);

    System.out.print("Test 13 - Allow multiple delimiters ::: ");
    System.out.println(
            "Input : '//[*][%]\\n1*2%3' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName(
          "Test 14 - make sure you can also handle multiple delimiters with length longer than one char")
  void testAdd14() {
    StringCalculator stringCalculator = new StringCalculator();
    String input = "//[**][%]\n1**2%3";
    int expected = 6;

    int actual = stringCalculator.add(input);

    System.out.print(
            "Test 14 - make sure you can also handle multiple delimiters with length longer than one char ::: ");
    System.out.println(
            "Input : '//[**][%]\\n1**2%3' :: Expected : " + expected + " :: Actual : " + actual);

    Assertions.assertEquals(expected, actual);
  }
}
