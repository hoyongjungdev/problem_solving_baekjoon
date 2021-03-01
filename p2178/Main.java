package p2178;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

  static class Pair {
    int y;
    int x;

    public Pair(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  int[] dx = new int[]{1, -1, 0, 0};
  int[] dy = new int[]{0, 0, 1, -1};

  public static void main(String[] args) {
    var main = new Main();
    var sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    sc.nextLine();

    var maze = new String[n];

    for (int i=0; i<n; i++) {
      var str = sc.nextLine();
      maze[i] = str;
    }

    System.out.println(main.dist(maze, n, m));
  }

  public int dist(String[] maze, int n, int m) {
    var dist = new int[n][m];

    for (int i=0; i<n; i++) {
      for (int j=0; j<m; j++) {
        dist[i][j] = -1;
      }
    }

    var deque = new ArrayDeque<Pair>();

    dist[0][0] = 1;
    deque.addLast(new Pair(0, 0));

    while (!deque.isEmpty()) {
      var pair = deque.removeFirst();

      for (int i=0; i<4; i++) {
        var ny = pair.y + dy[i];
        var nx = pair.x + dx[i];

        if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
          continue;
        }

        if (maze[ny].charAt(nx) == '0' || dist[ny][nx] != -1) {
          continue;
        }

        dist[ny][nx] = dist[pair.y][pair.x] + 1;
        deque.addLast(new Pair(ny, nx));
      }
    }

    return dist[n-1][m-1];
  }
}
