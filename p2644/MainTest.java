package p2644;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void dist() {
    var main = new Main();

    assertEquals(1, main.dist(2, 0, 1, new int[][]{{0, 1}}));
    assertEquals(-1, main.dist(4, 0, 2, new int[][]{{0, 1}, {2, 3}}));
    assertEquals(3, main.dist(4, 2, 3, new int[][]{{0, 1}, {0, 2}, {1, 3}}));
  }
}