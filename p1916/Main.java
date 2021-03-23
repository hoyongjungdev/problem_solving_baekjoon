package p1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static class Edge {

    int there;
    long cost;

    public Edge(int there, long cost) {

      this.there = there;
      this.cost = cost;
    }
  }

  ArrayList<ArrayList<Edge>> adj;
  long[] dist;
  boolean[] visited;
  long INF = 98765432111111L;

  public static void main(String[] args) throws IOException {
    var main = new Main();

    var br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    main.adj = new ArrayList<>();

    for (int i = 0; i < n + 1; i++) {
      main.adj.add(new ArrayList<>());
    }

    main.dist = new long[n + 1];

    for (int i = 1; i <= n; i++) {
      main.dist[i] = main.INF;
    }

    main.visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      var line = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(line.nextToken());
      int b = Integer.parseInt(line.nextToken());
      int c = Integer.parseInt(line.nextToken());

      main.adj.get(a).add(new Edge(b, c));
    }

    var line = new StringTokenizer(br.readLine(), " ");
    int start = Integer.parseInt(line.nextToken());
    int end = Integer.parseInt(line.nextToken());

    System.out.println(main.dijk(start, end));
  }

  long dijk(int start, int end) {
    var pq = new PriorityQueue<Edge>((e1, e2) -> (int) (e1.cost - e2.cost));
    pq.add(new Edge(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      var u = pq.poll();
      var here = u.there;
      var d = u.cost;

      if (visited[here]) {
        continue;
      }

      for (var e : adj.get(here)) {
        long newCost = d + e.cost;

        if (newCost < dist[e.there]) {
          dist[e.there] = newCost;
          pq.add(new Edge(e.there, newCost));
        }
      }

      visited[here] = true;
    }

    return dist[end];
  }
}
