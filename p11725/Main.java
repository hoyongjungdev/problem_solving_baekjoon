package p11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static int MAX_NUM = 1000005;

  static ArrayList<Integer>[] adj = new ArrayList[MAX_NUM];
  static boolean[] visited = new boolean[MAX_NUM];
  static int[] parent = new int[MAX_NUM];

  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    int n = Integer.parseInt(br.readLine());

    for (int i = 1; i <= n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      var line = br.readLine().split(" ");

      int a, b;
      a = Integer.parseInt(line[0]);
      b = Integer.parseInt(line[1]);

      adj[a].add(b);
      adj[b].add(a);
    }

    dfs(1);

    var sb = new StringBuilder();

    for (int i = 2; i <= n; i++) {
      sb.append(parent[i]);
      sb.append('\n');
    }

    System.out.println(sb.toString());
  }

  static void dfs(int node) {
    visited[node] = true;

    for (var next : adj[node]) {
      if (!visited[next]) {
        parent[next] = node;
        dfs(next);
      }
    }
  }
}
