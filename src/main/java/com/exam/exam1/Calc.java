package com.exam.exam1;

public class Calc {
    public int run(String s) {
        s = stripOuterBrackets(s);

        String operationCode = getOperationCode(s);

        switch (operationCode) {
            case "+" -> {
                return plus(s);
            }
            case "-" -> {
                return minus(s);
            }
            case "*" -> {
                return multi(s);
            }
            case "/" -> {
                return divide(s);
            }
            case "num" -> {
                return Integer.parseInt(s);
            }
            case "splitInTwo" -> {
                Polynomial poly = new Polynomial(s);

                String s1 = poly.getFirstTermStr();
                String s2 = poly.getRestTermsStr();

                int rs1 = run(s1);
                int rs2 = run(s2);

                return run("%s %s %s".formatted(rs1, poly.getSplitOperationCode(), rs2));
            }
        }

        throw new RuntimeException("계산가능한 수식이 아닙니다.");
    }

    private String getOperationCode(String s) {
        int count = Util.Str.countMatches(s, new String[]{" + ", " - ", " * ", " / ", "("});

        if (count <= 1) {
            return switch (s) {
                case String _s && _s.indexOf(" + ") != -1 -> "+";
                case String _s && _s.indexOf(" - ") != -1 -> "-";
                case String _s && _s.indexOf(" * ") != -1 -> "*";
                case String _s && _s.indexOf(" / ") != -1 -> "/";
                default -> {
                    try {
                        Integer.parseInt(s);

                        yield "num";
                    } catch (NumberFormatException e) {
                        yield "unknown";
                    }
                }
            };
        }

        return "splitInTwo";
    }

    private String stripOuterBrackets(String s) {
        while (s.startsWith("(") && s.endsWith(")")) {
            s = s.substring(1, s.length() - 1);
        }

        return s;
    }

    private int divide(String s) {
        String[] sBits = s.split(" \\/ ");

        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);

        return a / b;
    }

    private int multi(String s) {
        String[] sBits = s.split(" \\* ");

        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);

        return a * b;
    }

    private int minus(String s) {
        String[] sBits = s.split(" \\- ");

        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);

        return a - b;
    }

    private int plus(String s) {
        String[] sBits = s.split(" \\+ ");

        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);

        return a + b;
    }
}
