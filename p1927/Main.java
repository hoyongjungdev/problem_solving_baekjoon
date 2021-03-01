package p1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(
        new InputStreamReader(System.in)
    );
    int n = Integer.parseInt(br.readLine());

    var pq = new PriorityQueue<Integer>();

    var result = new ArrayList<Integer>();

    for (int i=0; i<n; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num == 0) {
        if (pq.isEmpty()) {
          result.add(0);
        } else {
          var top = pq.remove();
          result.add(top);
        }
      } else {
        pq.add(num);
      }
    }

    for (var r : result) {
      System.out.println(r);
    }
  }
}
