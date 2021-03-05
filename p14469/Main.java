package p14469;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static class Cow {

    int start;
    int duration;

    public Cow(int start, int duration) {
      this.start = start;
      this.duration = duration;
    }
  }

  public static void main(String[] args) {
    var sc = new Scanner(System.in);

    int n = sc.nextInt();
    var cows = new Cow[n];

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      cows[i] = new Cow(a, b);
    }

    Arrays.sort(cows, (c1, c2) -> Integer.compare(c1.start, c2.start));

    int time = 0;

    for (int i = 0; i < n; i++) {
      var cow = cows[i];
      if (time < cow.start) {
        time = cow.start + cow.duration;
      } else {
        time += cow.duration;
      }
    }

    System.out.println(time);
  }
}
