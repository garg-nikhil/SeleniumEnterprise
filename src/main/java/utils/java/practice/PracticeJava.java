package utils.java.practice;

import java.util.Arrays;

public class PracticeJava {

  public static void main(String[] args) {
    PracticeJava a = new PracticeJava();
    a.maxMin();
  }

  public void maxMin() {
    int[] arr = {1, 2, 3, 0, -1, -2, 23, 2, 1, 90, 2};
    int max = arr[0];
    int min = arr[0];

    for (int i = 0; i < arr.length; i++) {

      if (arr[i - 1] > max) {
        max = arr[i];
      }
      if (arr[i - 1] < min) {
        min = arr[i];
      }
    }

    System.out.println(max);
    System.out.println(min);
  }

  public void ana() {
    String s1 = "df";
    String s2 = "silent";
    boolean flag = false;

    if (s1.length() == s2.length()) {

      for (int i = 0; i < s1.length(); i++) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        if (c1[i] != c2[i]) {
          flag = false;
          break;
        }

        flag = true;
      }
    }

    if (flag) System.out.println("Anagram: " + flag);
    else System.out.println("Anagram: " + flag);
  }
}
