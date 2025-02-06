package DataStructure;

import java.util.Arrays;

public class code03 {
    //    二分法
    public static void findNum(int[] list, int num) {
        if (list == null || list.length == 0) {
            System.out.println("不存在该数");
            return;
        }

        int left = 0;
        int right = list.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (list[mid] == num) {
                System.out.println("找到了" + mid);
                return;
            } else if (list[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (list[left] == num) System.out.println("找到了" + left);
        else System.out.println("没有找到");
    }


    public static void findLeftIndex(int[] list, int num) {
        if (list == null || list.length == 0) {
            System.out.println("不存在该数");
            return;
        }
        int left = 0;
        int right = list.length - 1;
        int mid = 0;
        int index = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (list[mid] >= num) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("位置:" + index);
    }

    public static void findRightIndex(int[] list, int num) {
        if (list == null || list.length == 0) {
            System.out.println("不存在该数");
            return;
        }
        int left = 0;
        int right = list.length - 1;
        int mid = 0;
        int index = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (list[mid] <= num) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("位置:" + index);
    }


    public static void findPartMinIndex(int[] list) {
        if (list == null || list.length == 0) {
            System.out.println("数组为空");
            return;
        }
        if (list.length == 1) {
            System.out.println("局部最小值为" + list[0]);
            return;
        }
        int left = 0;
        int right = list.length - 1;
        if (list[left] < list[left + 1]) {
            System.out.println("局部最小值为" + list[left]);
            return;
        }
        if (list[right] < list[right - 1]) {
            System.out.println("局部最小值为" + list[right]);
            return;
        }
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if
            (list[mid] > list[mid + 1]) {
                left = mid + 1;
            } else if (list[mid] > list[mid - 1]) {
                right = mid - 1;
            } else {
                System.out.println("局部最小值index为" + mid);
                return;
            }
        }
        System.out.println("局部最小值index为" + left);
    }

    public static void main(String[] args) {
        int[] list = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        findNum(list, 5);
        int[] findIndexList = {1, 1, 3, 3, 5, 5, 7, 8, 9, 9, 10, 11};
        findLeftIndex(findIndexList, 9);
        findRightIndex(findIndexList, 9);
        int[] findMinList = {6, 5, 9, 8, 7, 10};
        findPartMinIndex(findMinList);

        System.out.println(getLessIndex(findMinList));

    }

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
