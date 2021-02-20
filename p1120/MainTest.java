package p1120;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {
  @Test
  public void test() {
    var main = new Main();

    assertEquals(0, main.diff("a", "a"));
    assertEquals(1, main.diff("a", "b"));
    assertEquals(0, main.diff("a", "ab"));
    assertEquals(0, main.diff("b", "ab"));
    assertEquals(1, main.diff("c", "ab"));
    assertEquals(2, main.diff("adaabc", "aababbc"));
  }
}