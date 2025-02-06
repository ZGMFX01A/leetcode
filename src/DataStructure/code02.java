package DataStructure;

public class code02 {
    public static void print(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
//选择排序
    public static void sort(int[] list) {
        if (list==null||list.length<2) {return;}
        for (int j = 0; j < list.length; j++) {
            int min = list[j];
            int index = j;
            for (int i = j+1; i < list.length; i++) {
                if (min > list[i]) {
                    min = list[i];
                    index = i;
                }
            }
            int temp = min;
            list[index] = list[j];
            list[j] = temp;
            System.out.println("第"+j+"次排序：");
            print(list);
        }
    }
//    冒泡排序
    public static void optimizeSort(int[] list){
        if (list == null || list.length < 2) {
            return;
        }
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
            System.out.println("第"+i+"次排序：");
            print(list);
        }
    }
//    插入排序
    public static void optimizeSort2(int[] list){
        if (list == null || list.length < 2) {
            return;
        }
        for (int i = 1; i < list.length; i++) {
//             for(int j=0; j<i;j++){
//                 if(list[j] > list[i]){
//                     int temp = list[j];
//                     list[j] = list[i];
//                     list[i] = temp;
//                 }
//             }



            // 直接插入排序，从后往前，每一轮找到一个元素并将其插入到正确的位置
//            for(int j=i-1;j>=0&&list[j]>list[j+1];j--){
//                int tmp=list[j];
//                list[j]=list[j+1];
//                list[j+1]=tmp;  // 交换元素
//            }
            int current = list[i]; // 当前待插入的元素
            int j = i - 1;

            // 找到合适的位置，将当前元素插入到已经排序部分的正确位置
            while (j >= 0 && list[j] > current) {
                list[j + 1] = list[j];  // 将元素向后移动
                j--;  // 向左移一位，继续查找合适的位置
            }

            // 插入当前元素
            list[j + 1] = current;

            System.out.println("第"+i+"次排序：");
            print(list);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 8, 1, 2, 7, 6, 3, 9, 0};
        print(arr);
//        sort(arr);
//        optimizeSort(arr);
        optimizeSort2(arr);


    }
}
