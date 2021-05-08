package p1890;

import java.util.Scanner;

public class Main {

  static int MAX_SIZE = 105;
  static int[][] board = new int[MAX_SIZE][MAX_SIZE];
  static long[][] cache = new long[MAX_SIZE][MAX_SIZE];

  static int n;

  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int num = sc.nextInt();
        board[i][j] = num;
        cache[i][j] = -1;
      }
    }

    System.out.println(numWays(0, 0));
  }

  static long numWays(int y, int x) {
    if (y == n - 1 && x == n - 1) {
      return 1;
    }

    if (cache[y][x] != -1) {
      return cache[y][x];
    }

    int size = board[y][x];

    long total = 0;

    if (size == 0) {
      cache[y][x] = total;
      return total;
    }

    if (y + size < n) {
      total += numWays(y + size, x);
    }

    if (x + size < n) {
      total += numWays(y, x + size);
    }

    cache[y][x] = total;
    return total;
  }
}
