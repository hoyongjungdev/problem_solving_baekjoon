package p10773;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  public void test() {
    var main = new Main();

    assertEquals(0, main.write(new int[]{3, 0, 4, 0}));
    assertEquals(7, main.write(new int[]{1, 3, 5, 4, 0, 0, 7, 0, 0, 6}));
  }
}