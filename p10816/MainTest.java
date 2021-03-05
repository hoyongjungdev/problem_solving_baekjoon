package p10816;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void count() {
    var main = new Main();

    assertArrayEquals(new int[]{1},
        main.count(new int[]{1}, new int[]{1}));

    assertArrayEquals(new int[]{0},
        main.count(new int[]{1}, new int[]{0}));

    assertArrayEquals(new int[]{0, 3, 2, 2},
        main.count(new int[]{1, 2, 3, 1, 2, 3, 1},
            new int[]{0, 1, 2, 3}));
  }
}