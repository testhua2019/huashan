package com.hua.sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//基数排序
public class RadixSort {
    public static void main(String[] args) {
        //int[] arr = {53, 3, 542, 748, 14, 214};
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));

        radixSort(arr);

        Date date1 = new Date();
        System.out.println(simpleDateFormat.format(date1));
    }

    public static void radixSort(int[] arr) {
        //定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含 10 个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        int digits = 0; //轮排到的个位,十位,百位
        //1. 得到数组中最大的数的位数
        int max = arr[0];//假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //使用循环代码实现
        for (int round = 0, n = 1; round < (max + "").length(); round++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素对应的位数
                digits = arr[j] / n % 10;
                //放入对应的桶中
                bucket[digits][bucketElementCounts[digits]] = arr[j];
                bucketElementCounts[digits]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int i = 0; i < bucketElementCounts.length; i++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[i] != 0) {
                    for (int k = 0; k < bucketElementCounts[i]; k++) {
                        //取出元素放入到 arr
                        arr[index] = bucket[i][k];
                        index++;
                    }
                    //第 i+1 轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                    bucketElementCounts[i] = 0;
                }
            }
            //System.out.println("第" + (round + 1) + "轮的数组:  " + Arrays.toString(arr));
        }

        /*
        //第1轮排序
        for (int j = 0; j < arr.length; j++) {
            digits = arr[j] % 10;
            bucket[digits][bucketElementCounts[digits]] = arr[j];
            bucketElementCounts[digits]++;
        }
        int index = 0;
        for (int i = 0; i < bucketElementCounts.length; i++) {
            if (bucketElementCounts[i] != 0) {
                for (int k = 0; k < bucketElementCounts[i]; k++) {
                    arr[index] = bucket[i][k];
                    index++;
                }
                bucketElementCounts[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));


        //第2轮
        for (int j = 0; j < arr.length; j++) {
            digits = arr[j] / 10 % 10;
            bucket[digits][bucketElementCounts[digits]] = arr[j];
            bucketElementCounts[digits]++;
        }
        index = 0;
        for (int i = 0; i < bucketElementCounts.length; i++) {
            if (bucketElementCounts[i] != 0) {
                for (int k = 0; k < bucketElementCounts[i]; k++) {
                    arr[index] = bucket[i][k];
                    index++;
                }
                bucketElementCounts[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));

        //第2轮
        for (int j = 0; j < arr.length; j++) {
            digits = arr[j] / 100 % 10;
            bucket[digits][bucketElementCounts[digits]] = arr[j];
            bucketElementCounts[digits]++;
        }
        index = 0;
        for (int i = 0; i < bucketElementCounts.length; i++) {
            if (bucketElementCounts[i] != 0) {
                for (int k = 0; k < bucketElementCounts[i]; k++) {
                    arr[index] = bucket[i][k];
                    index++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        */
    }
}
