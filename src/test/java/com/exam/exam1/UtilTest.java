package com.exam.exam1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {
    static class Str {
        @Test
        public void countMatches() {
            int count = Util.Str.countMatches(" 3 + 3 + 3", new String[]{" + ", " - ", " * ", " / "});

            assertEquals(2, count);
        }

        @Test
        public void countMatches_2() {
            int count = Util.Str.countMatches(" 3 * (3 / 3)", new String[]{" + ", " - ", " * ", " / ", "("});

            assertEquals(3, count);
        }
    }
}
