package p1012stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static class Pair {

    public int y;
    public int x;

    public Pair(int y, int x) {

      this.y = y;
      this.x = x;
    }
  }

  private int[][] visited;
  private int[][] map;
  private int n;
  private int m;

  public static void main(String[] args) {
    var main = new Main();
    var sc = new Scanner(System.in);

    var t = sc.nextInt();

    for (int testcase = 0; testcase < t; testcase++) {
      var m = sc.nextInt();
      var n = sc.nextInt();
      var k = sc.nextInt();

      var map = new int[n][m];

      for (int i = 0; i < k; i++) {
        int x = sc.nextInt();
        int y = sc.nextInt();

        map[y][x] = 1;
      }

      System.out.println(main.component(map, n, m));
    }
  }

  public int component(int[][] map, int n, int m) {
    this.map = map;
    this.n = n;
    this.m = m;

    this.visited = new int[n][m];

    int sum = 0;

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        sum += dfs(y, x);
      }
    }

    return sum;
  }

  public int dfs(int y, int x) {
    int found = 0;

    var stack = new Stack<Pair>();

    stack.push(new Pair(y, x));

    while (!stack.isEmpty()) {
      var pair = stack.peek();
      stack.pop();

      if (pair.y < 0 || pair.y >= n || pair.x < 0 || pair.x >= m) {
        continue;
      }

      if (this.map[pair.y][pair.x] == 0 || this.visited[pair.y][pair.x] == 1) {
        continue;
      }

      found = 1;
      this.visited[pair.y][pair.x] = 1;
      stack.push(new Pair(pair.y + 1, pair.x));
      stack.push(new Pair(pair.y - 1, pair.x));
      stack.push(new Pair(pair.y, pair.x + 1));
      stack.push(new Pair(pair.y, pair.x - 1));
    }

    return found;
  }
}
