package com.hua.sort;

import java.text.SimpleDateFormat;
import java.util.Date;


//归并排序
public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        Date date1 = new Date();
        System.out.println(simpleDateFormat.format(date1));
        //System.out.println("排序后的数组:" + Arrays.toString(arr));
    }

    //分离调用的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左分解
            mergeSort(arr, left, mid, temp);
            //向右分解
            mergeSort(arr, mid + 1, right, temp);

            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    //合并的方法

    /**
     * @param arr   排序的数组
     * @param left  数组最左的位置
     * @param mid   数组中间位置的前一个位置
     * @param right 数组最右的位置
     * @param temp  拷贝的临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;   //左数组的起始位置
        int j = mid + 1;    //右数组的起始位置
        int t = 0;  //指向temp的当前位置的索引
        //(一)
        //先把左右两边(有序)的数据按照规则填充到 temp 数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
                //即将左边的当前元素，填充到 temp 数组
                //然后 t++, i++
                temp[t] = arr[i];
                i += 1;
                t += 1;
            } else { //反之,将右边有序序列的当前元素，填充到 temp 数组
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }
        }
        //(二)
        //把有剩余数据的一边的数据依次全部填充到 temp
        while (i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到 temp
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }
        while (j <= right) { //右边的有序序列还有剩余的元素，就全部填充到 temp
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }
        //(三)
        //将 temp 数组的元素拷贝到 arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //System.out.println(left);
        //第一次合并 tempLeft = 0 , right = 1 //tempLeft = 2 right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0right = 7
        while (tempLeft <= right) {
            //System.out.println("xx");
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
