package com.turbosha.algorithm.offer;

/**
 * #5.替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class Solution5 {

    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') sb.append("%20");
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
