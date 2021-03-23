package p1654;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    var main = new Main();

    var sc = new Scanner(System.in);
    int k = sc.nextInt();
    int n = sc.nextInt();

    int[] nums = new int[k];

    for (int i=0; i<k; i++) {
      nums[i] = sc.nextInt();
    }

    long lo = 0;
    long hi = ((long) Integer.MAX_VALUE) + 1;

    while (lo < hi) {
      long mid = (lo + hi) / 2;

      if (main.possible(nums, mid, n)) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }

    System.out.println(hi - 1);
  }

  public boolean possible(int[] nums, long len, int n) {
    if (len == 0) {
      return true;
    }

    long lines = 0;

    for (int i=0; i<nums.length; i++) {
      lines += nums[i] / len;
    }

    return lines >= n;
  }
}
