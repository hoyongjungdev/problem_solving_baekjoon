package p9012;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void testIsValid() {
    var main = new Main();

    assertEquals(true, main.isValid("()"));
    assertEquals(false, main.isValid("(("));
    assertEquals(false, main.isValid("))"));
    assertEquals(false, main.isValid("())(()"));
    assertEquals(false, main.isValid("(())())"));
    assertEquals(false, main.isValid("(((()())()"));
    assertEquals(true, main.isValid("(()())((()))"));
    assertEquals(false, main.isValid("((()()(()))(((())))()"));
    assertEquals(true, main.isValid("()()()()(()()())()"));
    assertEquals(false, main.isValid("(()((())()("));
  }
}