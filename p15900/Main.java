package p15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static int MAX_NUM = 5000005;

  static ArrayList<Integer>[] adj = new ArrayList[MAX_NUM];
  static boolean[] visited = new boolean[MAX_NUM];
  static int[] depth = new int[MAX_NUM];

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

    dfs(1, 0);

    int sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += depth[i];
    }

    if (sum % 2 == 0) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }

  static void dfs(int node, int d) {
    visited[node] = true;
    boolean isLeaf = true;

    for (var next : adj[node]) {
      if (!visited[next]) {
        isLeaf = false;
        dfs(next, d + 1);
      }
    }

    if (isLeaf) {
      depth[node] = d;
    }
  }
}
