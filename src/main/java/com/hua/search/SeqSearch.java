package com.hua.search;

//线性查找
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {2, 55, 21, 3, 7, 5};
        int i = seqSearch(arr, 55);
        System.out.println(i);
    }

    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
