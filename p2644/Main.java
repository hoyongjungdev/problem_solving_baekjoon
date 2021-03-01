package p2644;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var main = new Main();
    var sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int m = sc.nextInt();

    var connect = new int[m][2];

    for (int i = 0; i < m; i++) {
      int p = sc.nextInt();
      int q = sc.nextInt();

      connect[i][0] = p - 1;
      connect[i][1] = q - 1;
    }

    System.out.println(
        main.dist(n, a - 1, b - 1, connect)
    );
  }

  public int dist(int n, int a, int b, int[][] connect) {
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (var c : connect) {
      int p = c[0];
      int q = c[1];

      adj[p].add(q);
      adj[q].add(p);
    }

    var deque = new ArrayDeque<Integer>();
    var distance = new int[n];

    for (int i = 0; i < n; i++) {
      distance[i] = -1;
    }

    distance[a] = 0;
    deque.addLast(a);

    while (!deque.isEmpty()) {
      int here = deque.removeFirst();

      for (int there : adj[here]) {
        if (distance[there] == -1) {
          distance[there] = distance[here] + 1;
          deque.addLast(there);
        }
      }
    }

    return distance[b];
  }
}
