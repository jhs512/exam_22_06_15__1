package com.exam.exam1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void 잘못된_수식은_예외를_유발() {
        Exception exception = assertThrows(RuntimeException.class, () -> new Calc().run("1 () 1"));

        String expectedMessage = "계산가능한 수식이 아닙니다.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void _1_더하기_1() {
        assertEquals(2, new Calc().run("1 + 1"));
    }

    @Test
    public void _1_더하기_2() {
        assertEquals(3, new Calc().run("1 + 2"));
    }

    @Test
    public void _1_빼기_1() {
        assertEquals(0, new Calc().run("1 - 1"));
    }

    @Test
    public void _1_빼기_2() {
        assertEquals(-1, new Calc().run("1 - 2"));
    }

    @Test
    public void _1_곱하기_1() {
        assertEquals(1, new Calc().run("1 * 1"));
    }

    @Test
    public void 숫자는_그대로_반환() {
        assertEquals(10, new Calc().run("10"));
    }

    @Test
    public void 숫자는_그대로_반환_2() {
        assertEquals(-10, new Calc().run("-10"));
    }

    @Test
    public void 바깥쪽_괄호는_제거() {
        assertEquals(10, new Calc().run("(10)"));
    }

    @Test
    public void 바깥쪽_괄호는_제거_2() {
        assertEquals(10, new Calc().run("((10))"));
    }

    @Test
    public void 바깥쪽_괄호는_제거_3() {
        assertEquals(-10, new Calc().run("((-10))"));
    }

    @Test
    public void 음수연산() {
        assertEquals(-1, new Calc().run("1 + -2"));
    }

    @Test
    public void 음수연산_2() {
        assertEquals(-1, new Calc().run("-2 + 1"));
    }

    @Test
    public void _3항_연산() {
        assertEquals(50, new Calc().run("10 + 20 + 20"));
    }

    @Test
    public void _4항_연산() {
        assertEquals(20, new Calc().run("10 + 20 + 20 + -30"));
    }

    @Test
    public void _4항_연산_2() {
        assertEquals(-120000, new Calc().run("10 * 20 * 20 * -30"));
    }

    @Test
    public void _4항_연산_3() {
        assertEquals(0, new Calc().run("3 * 1 + (1 - (4 * 1 - (1 - 1)))"));
    }

    @Test
    public void Util__Str__countMatches() {
        int count = Util.Str.countMatches(" 3 + 3 + 3", new String[]{" + ", " - ", " * ", " / "});

        assertEquals(2, count);
    }

    @Test
    public void Util__Str__countMatches__2() {
        int count = Util.Str.countMatches(" 3 * (3 / 3)", new String[]{" + ", " - ", " * ", " / ", "("});

        assertEquals(3, count);
    }

    @Test
    public void Polynomial__getSplitInfo() {
        assertEquals("3", new Polynomial("3 + 3").getFirstTermStr());
    }

    @Test
    public void Polynomial__getSplitInfo_2() {
        assertEquals("3", new Polynomial("3 + 3").getRestTermsStr());
    }

    @Test
    public void Polynomial__getSplitInfo_3() {
        assertEquals("3 * 3", new Polynomial("3 * 3 + 3").getFirstTermStr());
    }

    @Test
    public void Polynomial__getSplitInfo_4() {
        assertEquals("(3 + 3)", new Polynomial("(3 + 3) + 3").getFirstTermStr());
    }
}
