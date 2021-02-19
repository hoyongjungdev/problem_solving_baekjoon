package p2164;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {
  @Test
  public void test() {
    var main = new Main();

    assertEquals(1, main.card(1));
    assertEquals(2, main.card(2));
    assertEquals(2, main.card(3));
    assertEquals(4, main.card(4));
    assertEquals(4, main.card(6));
  }
}