package com.example.p1769;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        var sc = new Scanner(System.in);
        var str = sc.nextLine();
        var cnt = 0;

        while (str.length() > 1) {
            cnt++;

            int sum = 0;

            for (var c : str.toCharArray()) {
                sum += Character.digit(c, 10);
            }

            str = String.valueOf(sum);
        }

        System.out.println(cnt);

        if (str.equals("3") || str.equals("6") || str.equals("9")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
