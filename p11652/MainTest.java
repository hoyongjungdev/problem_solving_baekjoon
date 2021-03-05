package p11652;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void freq() {
    var main = new Main();

    assertEquals(-1, main.freq(new long[]{-1}));
    assertEquals(19876543211L, main.freq(new long[]{19876543211L}));
    assertEquals(1, main.freq(new long[]{1, 2, 1, 2, 1}));
    assertEquals(2, main.freq(new long[]{1, 2, 1, 2, 1, 2, 2}));
    assertEquals(1, main.freq(new long[]{1, 2, 1, 2, 1, 2}));

  }
}