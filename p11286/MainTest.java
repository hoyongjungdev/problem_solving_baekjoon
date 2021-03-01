package p11286;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void abs() {
    var main = new Main();
    assertArrayEquals(
        new Integer[]{-1, 1, 0, 1, 2},
        main.abs(new int[]{1, -1, 0, 0, 0, 1, 2, 0, 0})
    );
  }
}