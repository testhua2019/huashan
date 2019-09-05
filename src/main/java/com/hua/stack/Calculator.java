package com.hua.stack;

//使用栈,模拟计算器的加减乘除
public class Calculator {
    public static void main(String[] args) {
        String expression = "3922+9*9-2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch;   //表示当前遍历到的字符
        String keepNum = "";
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {  //遍历到的是符号
                if (!operStack.isEmpty()) {  //符号栈中有数据
                    //如果当前的操作符的优先级小于或者等于栈中的操作符
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
                        operStack.push(ch);
                    }
                } else {    //符号栈中没有数据
                    operStack.push(ch);
                }
            } else {    //如果是数字
//                numStack.push(ch-48);//字符的 1 ,在ASCII表中对应 49

                //分析思路
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向 expression 的表达式的 index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接

                //解决多位数的问题
                keepNum += ch;

                //如果 ch 已经是 expression 的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //重要,keepNum清空
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            if (!operStack.isEmpty()) {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = operStack.cal(num1, num2, oper);
                numStack.push(res);
            } else {
                break;
            }
        }
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);
    }

}

//使用数组来模拟一个栈
class ArrayStack2 {
    private int maxSize;    //栈的最大容量
    private int[] stack;    //使用数组模拟栈
    private int top = -1;    //表示栈顶

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈是否满了
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈~push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满了,无法加入数据");
            return;
        }
        top++;
        stack[top] = value;
        return;
    }

    //出栈~pop
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈中的数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空,没有数据");
            return;
        }
        for (int i = top; top >= 0; top--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    //判断是否是符号
    public boolean isOper(int val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //判断符号的优先级,优先级高数字大
    public int priority(int oper) {
        int res = 0;
        switch (oper) {
            case '*':
                res = 1;
                break;
            case '/':
                res = 1;
                break;
            case '+':
                res = 0;
                break;
            case '-':
                res = 0;
                break;
            default:
                res = -1;
                break;
        }
        return res;
    }

    public int peek() {
        return stack[top];
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
