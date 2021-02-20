package p1120;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var main = new Main();

    var sc = new Scanner(System.in);
    var input = sc.nextLine();

    var splitted = input.split(" ");

    var a = splitted[0];
    var b = splitted[1];

    System.out.println(main.diff(a, b));
  }

  public int diff(String a, String b) {
    var lenA = a.length();
    var lenB = b.length();

    var min = Integer.MAX_VALUE;

    for (int i = 0; i < lenB - lenA + 1; i++) {
      int cnt = 0;

      for (int j=0; j<lenA; j++) {
        if (a.charAt(j) != b.charAt(i + j)) {
          cnt++;
        }
      }

      min = Math.min(min, cnt);
    }

    return min;
  }
}
