package com.hua.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//        arrBinaryTree.preOrder();
//        arrBinaryTree.midOrder(0);
        arrBinaryTree.postOrder(0);
    }
}

//编写一个 ArrayBinaryTree, 实现顺序存储二叉树遍历
class ArrBinaryTree {
    private int[] arr;//存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }


    public void preOrder() {
        this.preOrder(0);
    }
    //编写一个方法，完成顺序存储二叉树的前序遍历

    /**
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,无法进行前序遍历");
            return;
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向右递归遍历
        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //中序遍历
    public void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,无法进行中序遍历");
            return;
        }
        if ((2 * index + 1) < arr.length) {
            midOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if ((2 * index + 2) < arr.length) {
            midOrder(2 * index + 2);
        }
    }

    //后序遍历
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,无法进行后序遍历");
            return;
        }
        if ((2 * index + 1) < arr.length) {
            postOrder(2 * index + 1);
        }
        if ((2 * index + 2) < arr.length) {
            postOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}
