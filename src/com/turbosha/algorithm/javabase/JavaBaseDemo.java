package com.turbosha.algorithm.javabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @Description java基础测试样例
 * @Author luoyuansha
 * @Date 2020/11/2 12:07
 */
public class JavaBaseDemo {

    public static void main(String[] args) {
        /**
         * 1、Integer 在-128~127之间有缓存
         */
        Integer one = 128;
        Integer two = 128;
        System.out.println(one == two);
        // java.lang.Integer.IntegerCache -128~127
        Integer one2 = 100;
        Integer two2 = 100;
        System.out.println(one2 == two2);

        /**
         * 2、参数传递
         */
        Integer total = 0;
        paramCheck(total);
        System.out.println(total);

        /**
         * 3、浮点数精度丢失问题：浮点数底层转化为二进制时出现精度丢失，不能用二进制正确表示浮点数
         */
        Float totalMoney = 20000.8f;
        Float ownMoney = 17000.5f;
        Float leftMoney = totalMoney - ownMoney;
        System.out.println("还剩余：" + leftMoney);


        /**
         * 4、整数在内存中使用补码形式表示，Integer.MAX_VALUE+1，值变为负数
         */
        int count = 0;
        int END_NUMBER = Integer.MAX_VALUE;
        int START_NUMBER = END_NUMBER - 2;
//        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
//            System.out.println(++count);
//        }

        /**
         * 5、finally返回值问题
         */
        System.out.println(findResult());

        /**
         * 6、数组问题： Arrays.asList(arr);实际上返回的是 java.util.Arrays.ArrayList内部类
         * 没有 add、remove、clear等方法
         */
        String[] arr = new String[]{"张三", "李四", "王五"};
        List<String> list = Arrays.asList(arr);
//        list.add("孙六");
        System.out.println(list.size());

        /**
         * 7、IO流 mkdir()创建目录（父目录要存在），mkdirs()递归创建目录
         */
        String path = "D:\\home\\nginx\\file";
//        new File(path).mkdir();
//        new File(path).mkdirs();

        /**
         * 8、计算机只存储补码，故byte达到最大值127后+1，变为-128
         */
        byte s1 = 127;
        s1 = (byte) (s1 + 1);
        short s2 = 1;
        s2 += 1;
        System.out.println(s1 + "   " + s2);

        System.out.println(Inner.paramOne);
        System.out.println(Inner.paramTwo);
        System.out.println(Inner.paramThree);

        int[] test = new int[]{1, 2, 3, 4};
        System.out.println(test.length);
        List ints = Arrays.asList(test);//将整个数组作为一个元素存入List
        System.out.println(ints.size());// size=1

        /**
         * List equals方法比较的是集合内的对象是否相等，而字符串在字符串常量池中，故相等
         */
        ArrayList<String> listOne = new ArrayList<>();
        listOne.add("this is list");
        Vector<String> vector = new Vector<>();
        vector.add("this is list");
        System.out.println(listOne.equals(vector));
    }

    static class Inner {
        static int paramOne = 5;
        static final int paramTwo = 5;
        static final int paramThree = new Integer(5);
    }

    private static boolean findResult() {
        // 因为正常情况下（异常情况：System.exit(0)；），finally最后执行
        // 其原理是，分别在try-catch后追加相同代码
        // 如果tra-catch中有返回值，finally中也有返回值，则finally返回值覆盖try-catch
        try {
            return true;
        } catch (Exception e) {
            return true;
        } finally {
            return false;
        }
    }

    private static void paramCheck(Integer total) {
        // 形参入栈，Integer指向同一对象
        if (total < 1) {
            total += 1;// but这里，实际上是Integer的拆装箱    Integer.valueOf(1)，形参指向了另一对象1，so原对象值不变
        }
    }


}
