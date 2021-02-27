package p1012stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  public void test() {
    var main = new Main();

    assertEquals(0, main.component(new int[][]{{0}}, 1, 1));
    assertEquals(1, main.component(new int[][]{{1}}, 1, 1));
    assertEquals(2, main.component(new int[][]{{0, 1}, {1, 0}}, 2, 2));
    assertEquals(1, main.component(new int[][]{{1, 1}, {1, 0}}, 2, 2));

  }
}