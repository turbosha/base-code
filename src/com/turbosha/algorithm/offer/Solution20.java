package com.turbosha.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * #20：表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 */
public class Solution20 {
    public static void main(String[] args) {
        Solution20 s = new Solution20();
        System.out.println(s.isNumber("."));
    }

    /**
     * 大佬解：分9种自动状态机
     *      空格、正负号、数字、小数点、幂符号
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }}, // 0.
                new HashMap() {{
                    put('d', 2);
                    put('.', 4);
                }}, // 1.
                new HashMap() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }}, // 2.
                new HashMap() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }}, // 3.
                new HashMap() {{
                    put('d', 3);
                }}, // 4.
                new HashMap() {{
                    put('s', 6);
                    put('d', 7);
                }}, // 5.
                new HashMap() {{
                    put('d', 7);
                }}, // 6.
                new HashMap() {{
                    put('d', 7);
                    put(' ', 8);
                }}, // 7.
                new HashMap() {{
                    put(' ', 8);
                }} // 8.
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else if (c == '.' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t)) return false;
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
