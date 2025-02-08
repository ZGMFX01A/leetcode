package DataStructure;

import java.util.HashMap;
import java.util.HashSet;

public class code04 {
    public static void main(String[] args) {
//        int a = 20;//a = 甲
//        int b = 90;//b = 乙
//        a = a ^ b;//a = 甲 ^ 乙
//        b = a ^ b;//b = 甲 ^乙 ^乙 = 甲 ^ ( 乙 ^ 乙 ) = 甲 ^ 0 = 甲
//        a = a ^ b;//a = 甲 ^ 乙 ^ 甲 = (甲 ^ 甲) ^乙 = 0 ^ 乙 = 乙
//        System.out.println("a=" + a);
//        System.out.println("b=" + b);
//        int[] numbers = {1, 1, 2, 2, 2, 3, 3, 3, 3, 6, 6, 7, 7};
//        findOddNumber(numbers);
//        int num = 9988;
//        print(num);
//        findRightOne(num);
//        int[] list = {6, 10, 6, 6, 4, 4, 12, 12, 12, 12};
//        findTwoOddNumber(list);
//
//
//        int[] list2 = {0, -23, -23, -69, -69, 0, -69, -23};
//        System.out.println("lazy:" + lazyFindK(list2, 2, 3));
//        System.out.println("fast:" + findK(list2, 2, 3));

        int k, m, kinds = 5, range = 100;
        int max = 9;

//        对数器测试
        System.out.println("测试开始");
        for (int i = 0; i < 500; i++) {
            int x = (int) (max * Math.random()) + 1;
            int y = (int) (max * Math.random()) + 1;
            k = Math.min(x, y);
            m = Math.max(x, y);
            if (k >= m) {
                m++;
            }
//            System.out.println("k:" + k+" m"+m);
            int[] arrary = randomList(k, m, range, kinds);

//            for (int num:arrary){
//                System.out.print(num+" ");
//            }
            int result1 = findK(arrary, k, m);
//            System.out.println("fast："+result1);
            int result2 = lazyFindK(arrary, k, m);
//            System.out.println("lazy："+result2);
            if (result1 != result2) {
                System.out.println("error!");
            }

        }
        System.out.println("测试结束");


    }

    public static void print(int args) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((args & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void findOddNumber(int[] numbers) {
        int result = 0;
        for (int num : numbers) {
            result ^= num;
        }
        System.out.println("Odd number: " + result);
    }


    public static void findRightOne(int number) {
        int rightOne = number & (~number + 1);
//        int rightOne=number&(-number);
        System.out.println("Rightmost one bit: " + rightOne);
    }


    public static void findTwoOddNumber(int[] numbers) {
        int eor = 0;
        int rightOne = 0;
        int eor1 = 0;
        for (int num : numbers) {
            eor ^= num;
        }
        rightOne = eor & (~eor + 1);
        for (int num : numbers) {
            if ((rightOne & num) != 0) {
                eor1 ^= num;
            }
        }
        System.out.println("First odd  number: " + eor1);
        System.out.println("second odd  number: " + (eor1 ^ eor));
    }

    public static int findK(int[] numbers, int k, int m) {
        int[] list = new int[32];
        for (int num : numbers) {
            for (int i = 0; i <= 31; i++) {
                if ((num >> i & 1) != 0) {
                    list[i]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            if (list[i] % m == 0) {
                continue;
            }
            if (list[i] % m == k) {
                result |= (1 << i);
            } else {
                return -1;
            }
        }
        if (result == 0) {
            int count = 0;
            for (int n : numbers) {
                if (n == 0) count++;
            }
            if (count != k) {
                return -1;
            }
        }

        return result;
    }

    public static int lazyFindK(int[] numbers, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : numbers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;  // 找到并返回出现次数为 k 的数字
            }
        }
        return -1;
    }


    public static int[] generateList(int listMaxSize, int maxValue) {
        int[] list = new int[(int) ((listMaxSize + 1) * Math.random())];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return list;
    }

    /**
     * @param k     k次
     * @param m     m次
     * @param range 数组元素范围
     * @param kinds 几种数
     * @return 符合条件的随机数组
     */

    public static int[] randomList(int k, int m, int range, int kinds) {
//        50%概率出现含有k次的数
        int times = Math.random() < 0.5 ? k : (int) (Math.random() * m);
//        设置出现 k次的数
        int keyNum = (int) ((range + 1) * Math.random()) - (int) ((range + 1) * Math.random());
//          随机至少出现2种以上的数
        int kind = (int) (kinds * Math.random()) + 2;
//           随机数组的长度等于出现了k次数的个数 + 出现了m次数的个数
//          k次数只有一种所以K*1，  其他数出现m次，所以还有kind-1种数
        int listLength = times * 1 + (kind - 1) * m;
        int[] list = new int[listLength];
        int i = 0;
        for (; i < times; i++) {
//            填充出现k次的数
            list[i] = keyNum;
        }
//        出现k次的数填完了，所以总的还有kind-1种数
        kind--;
        HashSet<Integer> existNum = new HashSet<>();
        existNum.add(keyNum);
        while (kind != 0) {
            int num = 0;
            do {
                num = (int) ((range + 1) * Math.random()) - (int) ((range + 1) * Math.random());
            } while (existNum.contains(num));//避免和出现k次的数重复
            existNum.add(num);
//            减少一种数
            kind--;
            for (int j = 0; j < m; j++) {
                list[i++] = num;
            }

        }
//        打乱数组内元素顺序
        for (int j = 0; j < listLength; j++) {
            int index = (int) (listLength * Math.random());
//            不要使用异或运算交换，交换的数字可能相同
            int temp = list[j];
            list[j] = list[index];
            list[index] = temp;
        }

        return list;

    }


}

