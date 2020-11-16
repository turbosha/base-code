package com.turbosha.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * #50：第一个只出现一次的字符
 */
public class Solution50 {

    /**
     * 哈希表：
     * 1、遍历字符串s，使用哈希表统“各字符串数量是否>1”
     * 2、再遍历字符串s，在哈希表中找到首个“数量为1的字符”，并返回
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            dic.put(aChar, dic.containsKey(aChar));
        }
        for (char aChar : chars) {
            if (!dic.get(aChar)) return aChar;
        }
        return ' ';
    }

    /**
     * 有序哈希表：键值对是按照插入顺序排序的，基于此，可通过遍历哈希表，实现搜索首个“数量为1”的字符
     * 1、遍历字符串s
     * 2、遍历有序哈希表dic
     *
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            dic.put(aChar, dic.containsKey(aChar));
        }
        for (Map.Entry<Character, Boolean> entry : dic.entrySet()) {
            if (!entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
