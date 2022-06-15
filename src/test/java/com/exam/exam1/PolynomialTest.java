package com.exam.exam1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolynomialTest {
    @Test
    public void getSplitInfo() {
        assertEquals("3", new Polynomial("3 + 3").getFirstTermStr());
    }

    @Test
    public void getSplitInfo_2() {
        assertEquals("3", new Polynomial("3 + 3").getRestTermsStr());
    }

    @Test
    public void getSplitInfo_3() {
        assertEquals("3 * 3", new Polynomial("3 * 3 + 3").getFirstTermStr());
    }

    @Test
    public void getSplitInfo_4() {
        assertEquals("(3 + 3)", new Polynomial("(3 + 3) + 3").getFirstTermStr());
    }
}
