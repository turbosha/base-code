package com.turbosha.algorithm.leetcode;

/**
 * #97 交错字符串 hard
 * <p>
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
public class Solution97 {

    public static boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if (length1 + length2 != length3) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        StringBuffer sb = new StringBuffer(length3);
        for (int i = 0; i < length3; i++) {
            char c1 = s1.charAt(index1);
            char c2 = s2.charAt(index2);
            char c3 = s3.charAt(i);
            if (c1 != c3 && c2 != c3) return false;
            if (c1 == c2 && c2 == c3){
                sb.append(c1);
                index1++;
                if (index1 == length1) {
                    while (index2 < length2) {
                        sb.append(s2.charAt(index2));
                        index2++;
                    }
                    return s3.equals(sb.toString());
                }
                i++;



            } c1 = c2;
            if (c1 == c3) {
                sb.append(c1);
                index1++;
                if (index1 == length1) {
                    while (index2 < length2) {
                        sb.append(s2.charAt(index2));
                        index2++;
                    }
                    return s3.equals(sb.toString());
                }
            } else {
                sb.append(c2);
                index2++;
                if (index2 == length2) {
                    while (index1 < length1) {
                        sb.append(s1.charAt(index1));
                        index1++;
                    }
                    return s3.equals(sb.toString());
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        boolean result = isInterleave(s1, s2, s3);
        System.out.println(result);
    }
}
