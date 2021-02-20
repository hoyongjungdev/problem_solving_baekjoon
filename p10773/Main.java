package p10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    var main = new Main();

    var br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();

    var k = Integer.parseInt(line);

    int[] numbers = new int[k];

    for (int i = 0; i < k; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }

    System.out.println(main.write(numbers));
  }

  public int write(int[] numbers) {
    var stack = new Stack<Integer>();

    for (int num : numbers) {
      if (num == 0) {
        stack.pop();
      } else {
        stack.push(num);
      }
    }

    var sum = 0;

    while (!stack.isEmpty()) {
      sum += stack.peek();
      stack.pop();
    }

    return sum;
  }
}
