package com.exam.exam1;

public class Polynomial {
    private String expressionStr;
    private int splitIndex;
    private char splitOperationCode;

    public Polynomial(String expressionStr) {
        this.expressionStr = expressionStr;
        ResultData<Integer, Character> rd = genSplitInfo();

        splitIndex = rd.d1();
        splitOperationCode = rd.d2();
    }

    private ResultData<Integer, Character> genSplitInfo() {
        int splitIndex = -1;
        int wrapBracketsCount = 0;

        outerLoop:
        for (int i = 0; i < expressionStr.length(); i++) {
            char ch = expressionStr.charAt(i);
            Character chNext = i == expressionStr.length() - 1 ? null : expressionStr.charAt(i + 1);

            switch (ch) {
                case '(' -> wrapBracketsCount++;
                case ')' -> wrapBracketsCount--;
                case '+', '-' -> {
                    if (wrapBracketsCount > 0) {
                        continue;
                    } else if (chNext != ' ') {
                        continue;
                    }

                    splitIndex = i;

                    break outerLoop;
                }
            }
        }

        if (splitIndex >= 0) {
            return new ResultData<>("S-1", "성공", splitIndex, expressionStr.charAt(splitIndex));
        }

        splitIndex = -1;
        wrapBracketsCount = 0;

        outerLoop:
        for (int i = 0; i < expressionStr.length(); i++) {
            char ch = expressionStr.charAt(i);
            Character chNext = i == expressionStr.length() - 1 ? null : expressionStr.charAt(i + 1);

            switch (ch) {
                case '(' -> wrapBracketsCount++;
                case ')' -> wrapBracketsCount--;
                case '*', '/' -> {
                    if (wrapBracketsCount > 0) {
                        continue;
                    } else if (chNext != ' ') {
                        continue;
                    }

                    splitIndex = i;

                    break outerLoop;
                }
            }
        }

        if (splitIndex >= 0) {
            return new ResultData<>("S-2", "성공", splitIndex, expressionStr.charAt(splitIndex));
        }

        throw new IllegalArgumentException("수식을 나누는데 실패했습니다.");
    }

    public String getFirstTermStr() {
        return expressionStr.substring(0, splitIndex).trim();
    }

    public String getRestTermsStr() {
        String restTermsStr = expressionStr.substring(splitIndex + 1).trim();

        if ( splitOperationCode == '-' ) {
            if ( restTermsStr.startsWith("(") == false ) {
                restTermsStr = "-" + restTermsStr;
            }
        }

        return restTermsStr;
    }

    public char getSplitOperationCode() {
        String restTermsStr = expressionStr.substring(splitIndex + 1).trim();

        if ( splitOperationCode == '-' ) {
            if ( restTermsStr.startsWith("(") == false ) {
                return '+';
            }
        }

        return splitOperationCode;
    }
}
