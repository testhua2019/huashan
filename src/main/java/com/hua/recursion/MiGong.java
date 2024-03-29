package com.hua.recursion;

public class MiGong {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        //设置迷宫的四周走不了,1 为走不了
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置障碍
        map[3][1] = 1;
        map[3][2] = 1;

//        map[2][2] = 1;
//        map[1][2] = 1;


        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        setWay2(map, 1, 1);
        System.out.println("----------------------------------------");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当 map[i][j] 为 0 表示该点没有走过 当为 1 表示墙； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯

    /**
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回 true, 否则返回 false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {    //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个点还没有走过
                map[i][j] = 2;  //假定i,j点可以走
                if (setWay(map, i + 1, j)) {    //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { //向左走
                    return true;
                } else {
                    //说明该点走不通,是思路,就返回
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j] != 0 ,可能是1,2,3
                return false;
            }
        }

    }

    //修改走的策略: 上->右->下->左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {    //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个点还没有走过
                map[i][j] = 2;  //假定i,j点可以走
                if (setWay2(map, i - 1, j)) {    //向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) { //向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) { //向左走
                    return true;
                } else {
                    //说明该点走不通,是思路,就返回
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j] != 0 ,可能是1,2,3
                return false;
            }
        }

    }


}
