package p2294;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static int INF = 999999;

  static int[] cache = new int[10005];

  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    var l = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      l.add(sc.nextInt());
    }

    for (int i = 0; i < 10005; i++) {
      cache[i] = -1;
    }

    int result = minCoins(k, l);

    if (result >= INF) {
      result = -1;
    }

    System.out.println(result);
  }

  static int minCoins(int sum, ArrayList<Integer> l) {
    if (sum == 0) {
      return 0;
    }

    if (cache[sum] != -1) {
      return cache[sum];
    }

    int result = INF;

    for (int coin : l) {
      if (sum < coin) {
        continue;
      }

      result = Math.min(result, 1 + minCoins(sum - coin, l));
    }

    cache[sum] = result;
    return result;
  }
}
