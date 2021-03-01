package p11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

  static class AbsoluteValue {

    int absVal;
    int originalVal;

    public AbsoluteValue(int absVal, int originalVal) {
      this.absVal = absVal;
      this.originalVal = originalVal;
    }
  }

  public static void main(String[] args) throws IOException {
    var main = new Main();
    var br = new BufferedReader(
        new InputStreamReader(System.in)
    );
    var n = Integer.parseInt(br.readLine());
    var ops = new int[n];

    for (int i = 0; i < n; i++) {
      ops[i] = Integer.parseInt(br.readLine());
    }

    var result = main.abs(ops);

    for (var r : result) {
      System.out.println(r);
    }
  }

  public Integer[] abs(int[] ops) {
    var pq = new PriorityQueue<AbsoluteValue>(
        (a1, a2) -> {
          if (a1.absVal == a2.absVal) {
            return Integer.compare(a1.originalVal, a2.originalVal);
          }

          return Integer.compare(a1.absVal, a2.absVal);
        }
    );

    var result = new ArrayList<Integer>();

    for (int o : ops) {
      if (o == 0) {
        if (pq.isEmpty()) {
          result.add(0);
        } else {
          var top = pq.remove();
          result.add(top.originalVal);
        }
      } else {
        pq.add(new AbsoluteValue(Math.abs(o), o));
      }
    }

    return result.toArray(new Integer[0]);
  }
}
