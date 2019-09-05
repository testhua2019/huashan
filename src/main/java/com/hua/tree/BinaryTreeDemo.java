package com.hua.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        BinaryTree binaryTree = new BinaryTree(root);
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        //binaryTree.setRoot(root);

//        System.out.println("前序遍历");
        //binaryTree.preOrder();

//        System.out.println("中序遍历");
        //binaryTree.medOrder();
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

//        System.out.println(binaryTree.preOrderSearch(1));
//        System.out.println(binaryTree.medOrderSearch(1));
//        System.out.println(binaryTree.postOrderSearch(5));

        System.out.println("删除前~");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        binaryTree.delNode(5);
        System.out.println("删除后~");
        binaryTree.preOrder();
    }
}

class BinaryTree {
    private HeroNode root;

    /**
     * @param root 指定二叉树的根结点
     */
    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    public void medOrder() {
        if (root != null) {
            root.medOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        }
        return null;
    }

    public HeroNode medOrderSearch(int no) {
        if (root != null) {
            return root.medOrderSearch(no);
        }
        return null;
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        }
        return null;
    }

    public void delNode(int no) {
        if (root != null) {
            //如果只有一个 root 结点, 这里立即判断 root 是不是就是要删除结点
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode2(no);
            }
        } else {
            System.out.println("二叉树为空！");
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode() {
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);//先输出父结点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void medOrder() {
        if (this.left != null) {
            this.left.medOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.medOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        int count = 0;
        count++;
        System.out.println(count);
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.preOrderSearch(no);
        }
        return res;
    }

    public HeroNode medOrderSearch(int no) {
        int count = 0;
        count++;
        System.out.println(count);
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.medOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            res = this.right.medOrderSearch(no);
        }
        return res;
    }


    public HeroNode postOrderSearch(int no) {
        int count = 0;
        count++;
        System.out.println(count);
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        return res;
    }

    //递归删除结点
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no) {
        //思路
/*
* 1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断
当前这个结点是不是需要删除结点.
2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将 this.left = null; 并且就返回
(结束递归删除)
3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将 this.right= null ;并且就返回
(结束递归删除)
4. 如果第 2 和第 3 步没有删除结点，那么我们就需要向左子树进行递归删除
5.如果第 4 步也没有删除结点，则应当向右子树进行递归删除.
*/
//2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将 this.left = null; 并且就返回(结束递归删除)

        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将 this.right= null ;并且就返回(结束递归删除)
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //4.我们就需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        //5.我们就需要向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    public void delNode2(int no) {
//        1)如果要删除的节点是非叶子节点，现在我们不希望将该非叶子节点为根节点的子树删除，需要指定规则, 假如
//        规定如下:
//        2)如果该非叶子节点 A 只有一个子节点 B，则子节点 B 替代节点 A
//        3)如果该非叶子节点 A 有左子节点 B 和右子节点 C，则让左子节点 B 替代节点 A。
        if (this.left != null && this.left.no == no) {
            if (this.left.left == null && this.left.right == null) {//如果是叶子节点 ，就直接删除
                this.left = null;
                return;
            }
            if (this.left.left != null) {
                HeroNode node = null;
                if (this.left.right != null) {  //同时有左右结点
                    node = this.right.right;
                }
                this.left = this.left.left; //有左结点时，优先指向左结点
                this.left.right = node; //同时有左右结点时，指向原先的右结点，否则指向null
                return;
            } else {    //左结点为null ，则直接指向右结点
                this.left = this.left.right;
                return;
            }
        }
        if (this.right != null && this.right.no == no) {
            if (this.right.left == null && this.right.right == null) {//如果是叶子节点 ，就直接删除
                this.left = null;
                return;
            }
            if (this.right.left != null) {
                HeroNode node = null;
                if (this.right.right != null) {
                    node = this.right.right;
                }
                this.right = this.right.left;
                this.right.right = node;
                return;
            } else {
                this.right = this.right.right;
                return;
            }
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}

