package com.hua.hashTab;

import java.util.Scanner;

//哈希表
public class hashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String s = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 遍历雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出程序");
            s = scanner.next();
            if ("add".equals(s)) {
                System.out.println("请输入ID");
                int id = scanner.nextInt();
                System.out.println("请输入名字");
                String name = scanner.next();
                hashTab.add(new Emp(id, name));
            } else if ("list".equals(s)) {
                hashTab.list();
            } else if ("find".equals(s)) {
                System.out.println("请输入id");
                int id = scanner.nextInt();
                hashTab.findOneById(id);
            } else if ("del".equals(s)) {
                System.out.println("请输入指定删除的id");
                int id = scanner.nextInt();
                hashTab.del(id);
            } else if ("exit".equals(s)) {
                scanner.close();
                System.exit(0);
            }
        }
    }
}

//创建hashTab ,管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArr;
    private int size;   //表示有多少条链表

    public HashTab(int size) {
        this.size = size;
        empLinkedListArr = new EmpLinkedList[this.size];
        //这是需要分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int arrNo = hashFun(emp.getId());
        empLinkedListArr[arrNo].add(emp);
    }

    public void findOneById(int id) {
        int arrNo = hashFun(id);
        Emp emp = empLinkedListArr[arrNo].findOneById(id);
        if (emp != null) {
            System.out.printf("第 " + (arrNo + 1) + " 链表 => id = %d  name = %s \n", emp.getId(), emp.getName());
        } else {
            System.out.println("链表为空或没有找到该id~");
        }

    }

    public void del(int id) {
        int arrNo = hashFun(id);
        int i = empLinkedListArr[arrNo].delete(id);
        if (i == 1) {
            System.out.println("成功删除id = " + id + " 节点");
        } else {
            System.out.println("没有找到该节点");
        }
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i].list(i);
        }
    }

    //编写散列函数, 使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }

}

//创建 EmpLinkedList ,表示链表
class EmpLinkedList {
    //头指针，执行第一个 Emp,因此我们这个链表的 head 是直接指向第一个 Emp
    private Emp head;//默认为 null

    public EmpLinkedList(Emp head) {
        this.head = head;
    }

    public EmpLinkedList() {
    }

    //添加是保证id是从低到高排序
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        if (head.getId() > emp.getId()) {
            head = emp;
            emp.setNext(curEmp);
            return;
        }
        Emp next = curEmp.getNext();
        while (curEmp.getNext() != null) {
            if (next.getId() > emp.getId()) {
                emp.setNext(next);
                curEmp.setNext(emp);
                return;
            }
            if (curEmp.getNext() == null) {
                break;
            }
            curEmp = curEmp.getNext();
            next = next.getNext();
        }
        curEmp.setNext(emp);

    }

    public Emp findOneById(int id) {
        if (head == null) {
            return null;
        }

        Emp curEmp = head;
        while (true) {
            if (curEmp.getId() == id) {
                return curEmp;
            }
            if (curEmp.getNext() == null) {
                return null;
            }
            curEmp = curEmp.getNext();
        }
    }

    //删除成功返回 1 ,否则返回 -1
    public int delete(int id) {
        if (head.getId() == id) {
            if (head.getNext() != null) {
                head = head.getNext();
            } else {
                head = null;
            }
            return 1;
        }
        Emp curEmp = head;
        while (curEmp.getNext() != null) {
            if (curEmp.getNext().getId() == id) {
                curEmp.setNext(curEmp.getNext().getNext());
                return 1;
            }
            curEmp = curEmp.getNext();
        }
        return -1;
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第 " + (no + 1) + " 链表为空~");
            return;
        }
        Emp curEmp = head;
        System.out.print("第 " + (no + 1) + "链表 => ");
        while (true) {
            System.out.printf("ID= %d ,名字= %s ", curEmp.getId(), curEmp.getName());
            if (curEmp.getNext() == null) {
                break;
            }
            curEmp = curEmp.getNext();
        }
        System.out.println();
    }
}

//雇员类
class Emp {
    private int id;
    private String name;
    private Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}
