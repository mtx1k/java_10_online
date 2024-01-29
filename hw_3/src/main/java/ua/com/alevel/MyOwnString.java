package ua.com.alevel;

import java.util.Arrays;

public class MyOwnString {
    public static String reverse(String src) {
        char[] reverses = new char[src.length()];
        for (int i = 0; i < src.length(); i++) {
            reverses[src.length() - i - 1] = src.charAt(i);
        }
        return new String(reverses);
    }
    public static String reverse(String src, String dest) {
        char[] reverses = new char[src.length()];
        for (int i = 0; i < src.length(); i++) {
            reverses[i] = src.charAt(i);
            if(src.charAt(i) == dest.charAt(0)) {
                char[] chars = new char[dest.length()];
                for (int j = 0, k = i; j < dest.length() && k < src.length(); j++, k++) {
                    chars[j] = src.charAt(k);
                    if(j == dest.length() - 1 && dest.equals(new String(chars))) {
                        for (int l = chars.length - 1; l >= 0; l--) {
                            reverses[i++] = chars[l];
                        }
                        i--;
                    }
                }
            }
        }
        return new String(reverses);
    }
    public static String reverse(String src, int firstIndex, int lastIndex) {
        if(lastIndex > src.length()) {
            lastIndex = src.length() - firstIndex;
        }
        char[] reverses = new char[src.length()];
        for (int i = 0; i < src.length(); ) {
            if(i == firstIndex) {
                for (int j = i + lastIndex - firstIndex; j >= firstIndex; j--) {
                    reverses[i++] = src.charAt(j);
                }
            } else {
                reverses[i] = src.charAt(i++);
            }
        }
        return new String(reverses);
    }
}
