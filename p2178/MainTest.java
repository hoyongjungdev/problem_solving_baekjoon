package p2178;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  public void test() {
    var main = new Main();
    assertEquals(3, main.dist(new String[]{"11", "11"}, 2, 2));
    assertEquals(3, main.dist(new String[]{"10", "11"}, 2, 2));
    assertEquals(3, main.dist(new String[]{"11", "01"}, 2, 2));
    assertEquals(15, main.dist(new String[]{
        "101111",
        "101010",
        "101011",
        "111011",
    }, 4, 6));
    assertEquals(9, main.dist(new String[]{
        "110110",
        "110110",
        "111111",
        "111101",
    }, 4, 6));
  }
}