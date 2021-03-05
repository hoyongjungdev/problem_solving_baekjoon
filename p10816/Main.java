package p10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    var main = new Main();
    var br = new BufferedReader(
        new InputStreamReader(System.in)
    );

    int n = Integer.parseInt(br.readLine());

    var nums = new int[n];
    var st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    var m = Integer.parseInt(br.readLine());

    var questions = new int[m];
    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < m; i++) {
      questions[i] = Integer.parseInt(st.nextToken());
    }

    var result = main.count(nums, questions);

    var sb = new StringBuilder();

    for (var r: result) {
      sb.append(r);
      sb.append(' ');
    }

    System.out.println(sb.toString());
  }

  public int[] count(int[] nums, int[] questions) {
    var doubleNum = new int[nums.length];

    for (int i=0; i<nums.length; i++) {
      doubleNum[i] = nums[i] * 2;
    }

    Arrays.sort(doubleNum);

    var result = new int[questions.length];

    for (int i = 0; i < questions.length; i++) {
      int found = Arrays.binarySearch(doubleNum, questions[i] * 2 - 1);

      int foundAfter = Arrays.binarySearch(doubleNum, questions[i] * 2 + 1);

      result[i] = found - foundAfter;
    }

    return result;
  }
}
