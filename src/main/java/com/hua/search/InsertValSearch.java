package com.hua.search;

//插值查找
//        1)对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
//        2)关键字分布不均匀的情况下，该方法不一定比折半查找要好
public class InsertValSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        //System.out.println("数组是: " + Arrays.toString(arr));

        int index = insertValSearch(arr, 0, arr.length - 1, 4);
        System.out.println(index);
    }


    /**
     * @param arr   数组
     * @param left  左边的索引
     * @param right 右边的索引
     * @param val   查找的值
     * @return 找到对应的值, 则返回索引, 找不到返回 -1 ;
     */
    public static int insertValSearch(int[] arr, int left, int right, int val) {
        System.out.println("插值查找次数");
        if (left > right || arr[left] > val || arr[right] < val) {
            return -1;
        }
        int mid = left + (right - left) * (val - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (midVal < val) {//向右
            return insertValSearch(arr, mid + 1, right, val);
        } else if (mid > val) {
            return insertValSearch(arr, left, mid - 1, val);
        } else {
            return mid;
        }
    }
}
