package p9934;

import java.util.Scanner;

public class Main {

  static int MAX_NUM = 2000;

  static int[] buildings = new int[MAX_NUM];
  static int size;
  static int[] record = new int[MAX_NUM];
  static int now = 0;

  public static void main(String[] args) {
    var sc = new Scanner(System.in);

    int k = sc.nextInt();

    size = pow(k) - 1;

    for (int i = 0; i < size; i++) {
      record[i] = sc.nextInt();
    }

    dfs(1);

    for (int i = 0; i < k; i++) {
      int start = pow(i);
      int end = pow(i + 1);

      for (int j = start; j < end; j++) {
        System.out.print(buildings[j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  static int pow(int k) {
    int result = 1;

    while (k > 0) {
      result *= 2;
      k--;
    }

    return result;
  }

  static void dfs(int node) {
    //System.out.println("here: " + node);

    int left = node * 2;
    int right = node * 2 + 1;

    if (possible(left)) {
      dfs(left);
    }

    //System.out.println("visiting: " + node + " " + now);
    buildings[node] = record[now];
    now++;

    if (possible(right)) {
      dfs(right);
    }
  }

  static boolean possible(int node) {
    return 1 <= node && node <= size && buildings[node] == 0;
  }
}
