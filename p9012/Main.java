package p9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    var main = new Main();
    var sc = new Scanner(System.in);

    var n = sc.nextInt();
    sc.nextLine();

    for (var i=0; i<n; i++) {
      var p = sc.nextLine();
      if (main.isValid(p)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  public boolean isValid(String p) {
    var stack = new Stack<Character>();

    for (Character c: p.toCharArray()) {
      if (c.equals('(')) {
        stack.push(c);
      } else {
        if (!stack.isEmpty() && stack.peek().equals('(')) {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
    }

    return stack.isEmpty();
  }
}