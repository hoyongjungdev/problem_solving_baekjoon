package p1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    int n = Integer.parseInt(br.readLine());

    var lower = new PriorityQueue<Integer>((a, b) -> b - a);
    var higher = new PriorityQueue<Integer>();

    var result = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());

      if (higher.size() == 0 || num <= higher.peek()) {
        lower.add(num);
      } else {
        int top = higher.poll();
        lower.add(top);
        higher.add(num);
      }

      if (lower.size() >= higher.size() + 2) {
        int top = lower.poll();
        higher.add(top);
      }

      result.append(lower.peek());
      result.append('\n');
    }

    System.out.println(result);
  }
}
