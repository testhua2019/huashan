package com.hua.sparsearray;

//稀疏数组
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][7] = 1;
        for (int[] ints : chessArr) {
            for (int i : ints) {
                System.out.print(i+"    ");
            }
            System.out.println();
        }
        // 将二维数组 转 稀疏数组的思
        // 1. 先遍历二维数组 得到非 0 数据的个数
        int sum = 0;
        for (int[] ints : chessArr) {
            for (int i : ints) {
                if (0 != i) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 遍历二维数组，将非 0 的值存放到 sparseArr 中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int[] ints : sparseArr) {
            for (int i : ints) {
                System.out.print(i+"    ");
            }
            System.out.println();
        }

        //将稀疏数组 --》 恢复成 原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] ints : chessArr2) {
            for (int i : ints) {
                System.out.print(i+"    ");
            }
            System.out.println();
        }
    }
}
