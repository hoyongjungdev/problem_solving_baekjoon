package p1012;

import java.util.Scanner;

public class Main {

  private int[][] visited;
  private int[][] map;
  private int n;
  private int m;
  int[] dy = new int[]{0, 0, 1, -1};
  int[] dx = new int[]{1, -1, 0, 0};

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
        sum += doDfs(y, x);
      }
    }

    return sum;
  }

  public int doDfs(int y, int x) {
    if (this.map[y][x] == 0 || this.visited[y][x] == 1) {
      return 0;
    }

    this.visited[y][x] = 1;
    dfs(y, x);

    return 1;
  }

  public void dfs(int y, int x) {
    for (int i = 0; i < 4; i++) {
      var ny = y + dy[i];
      var nx = x + dx[i];

      if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
        continue;
      }

      if (this.map[ny][nx] == 0 || this.visited[ny][nx] == 1) {
        continue;
      }

      this.visited[ny][nx] = 1;
      dfs(ny, nx);
    }
  }
}
