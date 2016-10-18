package fileWork;

import java.util.StringTokenizer;

public class EditText {
    public static String delete(String text) {
        StringBuilder resultText = new StringBuilder();
        StringTokenizer strtok = new StringTokenizer(text, "\n");
        boolean isComment = false;
        while (strtok.hasMoreTokens()) {
            StringBuilder currStr = new StringBuilder(strtok.nextToken() + "\n");
            int currLength = currStr.length();
            for (int i = 0; i < currLength; i++) {
                if (!isComment && currStr.charAt(i) == '"') {
                    resultText.append(currStr.charAt(i));
                    i++;
                    while (i < currLength && !endOfString(currStr, i)) {
                        resultText.append(currStr.charAt(i));
                        i++;
                    }
                }
                if (!isComment && i < currLength && currStr.charAt(i) == '/' && currStr.charAt(i + 1) == '*') {
                    i+=2;
                    isComment = true;
                }
                if (isComment && i < currLength && currStr.charAt(i) == '*' && currStr.charAt(i + 1) == '/') {
                    i+=2;
                    isComment = false;
                }
                if (!isComment && i < currLength && currStr.charAt(i) == '/' && currStr.charAt(i + 1) == '/') {
                    resultText.append("\n");
                    break;
                }
                if (!isComment && i < currLength) {
                    resultText.append(currStr.charAt(i));
                }
            }
        }
        return resultText.toString();
    }
    private static boolean endOfString(StringBuilder str, int index) {
        if (index < str.length() && str.charAt(index) == '"') {
            return true;
        }
        return false;
    }
}
