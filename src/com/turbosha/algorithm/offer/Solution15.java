package com.turbosha.algorithm.offer;

/**
 * #15：二进制中1的个数
 */
public class Solution15 {

    /**
     * n&n-1的妙用：
     *      若n为2的幂，则n&n-1为0
     *      将二进制n最右边的1，变成0
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //计算一个（byte,short,char,int统一按照int方法计算）int,long类型的数值在二进制下“1”的数量
//        Integer.bitCount(n);
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }


    /**
     * 2进制转10进制
     *
     * @param n
     */
    public static void binaryToDecimal(int n) {
        int decimal = 0, i = 0;
        while (true) {
            if (n == 0) break;
            int temp = n % 10;
            decimal += temp * Math.pow(2, i++);// 对10取余，将余数乘以2的倍数，并累加
            n = n / 10; // n商10，舍一位
        }
        System.out.println(decimal);
    }

    /**
     * 10进制转2进制
     *
     * @param n
     */
    public static void decimalToBinary(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 + str; // 对2取余，从余数底部往上加
            n = n / 2;
        }
        System.out.println(str);
    }
}
