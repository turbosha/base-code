package com.turbosha.algorithm.leetcode;

/**
 * @Description #3：无重复字符的最长子串 中等
 * https://leetcode-cn.com/submissions/detail/93381348/
 * @Author luoyuansha
 * @Date 2020/10/28 14:18
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        // flag起始标记位，result，length最大子串长度，i
        int flag = 0, result = 0, length = 0, i = 0;
        while (i < s.length()) {
            // 从flag位开始查找 索引字符的位置
            int pos = s.indexOf(s.charAt(i), flag);
            // pos是不可能大于i的，就是从i处取的字符，而flag又不会大于i，所以pos始终<=i
            if (pos < i) {
                // 说明从起始标记位开始，存在重复字符
                if (length > result) {
                    // 赋值result
                    result = length;
                }
                // result是子串长度的最大值
                // s.length-(pos+1)的意思是，除去重复字符索引的位置，剩余子串的长度
                // 如果result已经大于剩余子串的长度，故以两个重复字符串为界，即使后面字符均不重复，也无法超过result了
                if (result >= s.length() - pos - 1) {
                    // result已达字符串非重复最大长度
                    return result;
                }
                // 到这里是因为，最后两个字符重复了，i-pos=1。但是长度至少有一个，而后面又有自增运算，所以需要再减1
                length = i - pos - 1;
                // 起始标记位右移一位，因为两端重复了
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }

}
