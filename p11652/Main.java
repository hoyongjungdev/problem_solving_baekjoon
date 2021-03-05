package p11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    var main = new Main();
    var br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    int n = Integer.parseInt(br.readLine());

    var nums = new long[n];

    for (int i = 0; i < n; i++) {
      nums[i] = Long.parseLong(br.readLine());
    }

    System.out.println(main.freq(nums));
  }

  public long freq(long[] nums) {
    Arrays.sort(nums);

    long lastNum = nums[0];
    int length = 1;
    int maxLength = -1;
    long maxNum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == lastNum) {
        length++;
      } else {
        lastNum = nums[i];

        if (length > maxLength) {
          maxLength = length;
          maxNum = nums[i - 1];
        }

        length = 1;
      }
    }
    if (length > maxLength) {
      maxNum = nums[nums.length - 1];
    }

    return maxNum;
  }
}
