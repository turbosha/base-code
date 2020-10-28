package com.turbosha.algorithm.juc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;

public class Solution {

    public int treePlanning(int[] trees, int d) {
        int pre = trees[0], s = 0;
        for (int i = 1; i < trees.length; i++) {
            if (trees[i] - pre < d) {
                s++;
            } else {
                pre = trees[i];
            }
        }
        return s;
    }

    /**
     * @param lengths: the lengths of sticks at the beginning.
     * @return: return the minimum number of cuts.
     */
    public static int makeEquilateralTriangle(int[] lengths) {
        Arrays.sort(lengths);
        Set set = new HashSet();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < lengths.length; i++) {
            Integer num = map.get(lengths[i]);
            num = num == null ? 1 : num + 1;
            map.put(lengths[i], num);
            if (num >= 3) return 0;
            if (num == 2) {
                set.add(lengths[i]);
            }
            if (lengths[i] % 2 == 0) {
                Integer integer = map.get(lengths[i] / 2);
                if (integer != null && integer > 0) return 1;
            } else {
                int i1 = lengths[i] / 2;
                if (set.contains(i1)) return 1;
                if (set.contains(i1 + 1)) return 1;
            }
        }
        return 2;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        InvocationHandler handler = Proxy.getInvocationHandler(solution);
        ClassLoader classLoader = Solution.class.getClassLoader();
        Object instance = Proxy.newProxyInstance(classLoader, new Class<?>[]{Solution.class}, handler);
        System.out.println(5 ^ 6);
        int[] nums = {2, 6, 3, 5};
        int count = makeEquilateralTriangle(nums);
        System.out.println(count);
    }


    /**
     * @param num: array of num
     * @param ask: Interval pairs
     * @return: return the sum of xor
     */
    public int Intervalxor(int[] num, List<List<Integer>> ask) {
        // write your code here
        Arrays.sort(num);
        List<Integer> list = new ArrayList();
        List<Integer> res = new ArrayList();
        for (int i = 0; i < ask.size(); i++) {
            List<Integer> integers = ask.get(i);
            for (int j = 0; j < num.length; j++) {
                if (num[j] <= integers.size())
                    list.add(integers.get(num[j] - 1));
            }
            if (list.size() % 2 == 0) {
                Integer lmax = list.get(list.size() - 2);
                Integer rmin = list.get(1);
                res.add(lmax + rmin);
            }
            list.clear();
        }
        if (res.size() == 0) return 0;
        int cun = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            cun = cun ^ res.get(i);
        }
        return cun;
    }

    public int Fivecharacterpalindrome(String s) {
        // write your code here
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i + j < n && i - j >= 0 && s.charAt(i - j) == s.charAt(i + j); j++) ans++;
            for (int j = 0; i + j < n && i - 1 - j >= 0 && s.charAt(i - 1 - j) == s.charAt(i + j); j++) ans++;
        }
        return ans;
    }

}
