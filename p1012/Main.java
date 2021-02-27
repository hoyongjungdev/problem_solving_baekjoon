package p1012;

import java.util.Scanner;

public class Main {

  private int[][] visited;
  private int[][] map;
  private int n;
  private int m;

  public static void main(String[] args) {
    var main = new Main();
    var sc = new Scanner(System.in);

    var t = sc.nextInt();

    for (int testcase=0; testcase<t; testcase++) {
      var m = sc.nextInt();
      var n = sc.nextInt();
      var k = sc.nextInt();

      var map = new int[n][m];

      for (int i=0; i<k; i++) {
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
    if (y < 0 || y >= n || x < 0 || x >= m) {
      return 0;
    }

    if (this.map[y][x] == 0 || this.visited[y][x] == 1) {
      return 0;
    }

    this.visited[y][x] = 1;

    dfs(y + 1, x);
    dfs(y - 1, x);
    dfs(y, x + 1);
    dfs(y, x - 1);

    return 1;
  }
}
