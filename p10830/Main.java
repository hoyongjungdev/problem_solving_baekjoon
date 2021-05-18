package p10830;

import java.util.Scanner;

public class Main {

  static class Matrix {

    public int[][] value;
    public int size;

    public Matrix(int size, int[][] value) {
      this.size = size;

      this.value = new int[size][size];

      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          this.value[i][j] = value[i][j];
        }
      }
    }

    public Matrix mult(Matrix other) {
      int[][] multedValue = new int[size][size];

      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          int sum = 0;

          for (int k = 0; k < size; k++) {
            sum += value[i][k] * other.value[k][j];
          }

          multedValue[i][j] = sum % 1000;
        }
      }

      return new Matrix(size, multedValue);
    }

    public Matrix power(int num) {
      Matrix a = new Matrix(size, value);
      for (int i = 0; i < num - 1; i++) {
        a = a.mult(this);
      }

      return a;
    }

    public Matrix fastPower(long num) {
      if (num <= 5) {
        return this.power((int) num);
      }

      if (num % 2 == 0) {
        long d = num / 2;
        var p = this.fastPower(d);
        return p.mult(p);
      } else {
        return this.mult(this.fastPower(num - 1));
      }
    }
  }

  public static void main(String[] args) {
    var sc = new Scanner(System.in);

    int n = sc.nextInt();
    long b = sc.nextLong();

    int[][] value = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        value[i][j] = sc.nextInt() % 1000;
      }
    }

    var m = new Matrix(n, value);

    var p = m.fastPower(b);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(String.format("%d ", p.value[i][j]));
      }
      System.out.println();
    }
  }
}
