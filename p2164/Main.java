package p2164;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var main = new Main();

    var sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(main.card(n));
  }

  public int card(int num) {
    var deque = new ArrayDeque<Integer>();

    for (int i = 1; i <= num; i++) {
      deque.addLast(i);
    }

    var count = 0;

    while (deque.size() > 1) {
      if (count % 2 == 0) {
        deque.removeFirst();
      } else {
        var top = deque.getFirst();
        deque.removeFirst();
        deque.addLast(top);
      }

      count++;
    }

    return deque.getFirst();
  }
}
