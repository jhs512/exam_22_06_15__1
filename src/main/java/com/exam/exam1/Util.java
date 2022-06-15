package com.exam.exam1;

public class Util {

    public static class Str {
        public static int countMatches(String s, String[] matches) {

            int count = 0;

            for (String match : matches) {
                for (int offset = 0; true; count++) {
                    int index = s.indexOf(match, offset);

                    if (index == -1) {
                        break;
                    }

                    offset = index + match.length();
                }
            }

            return count;
        }
    }
}
