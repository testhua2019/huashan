package com.hua.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
//        1+((2+3)×4)-5
        //定义一个  中缀表达式
        String expression = "12+((23+3)*4)-5";
        //把字符串 放到 list 中
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        //把 list 中的中缀形式转换成  后缀表达式 的形式
        List<String> suffixExpreesionList = parseSuffixExpreesionList(list);
        System.out.println(suffixExpreesionList);
        //计算集合中 后缀表达式的结果
        System.out.println(calculation(suffixExpreesionList));
        /*//  ( 3+ 4 )* 5 -6
        //后缀表达式
//      String suffixExpression = "3 4 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / + ";
        //把数字和操作符都放入集合中,方便操作
        List<String> list = getListString(suffixExpression);
        System.out.println("后缀表达式为: " + list);
        int res = calculation(list);
        System.out.println("结果是: " + res);
        */
    }

    //返回运算符优先级
    public static int getValue(String str) {
        int res = 0;
        if (str.equals("+")) {
            res = 1;
        } else if (str.equals("-")) {
            res = 1;
        } else if (str.equals("*")) {
            res = 2;
        } else if (str.equals("/")) {
            res = 2;
        } else if (str.equals("(")) {
            res = 0;
        } else {
            System.out.println("未知的运算符");
        }
        return res;
    }

    //方法：将得到的中缀表达式对应的 List => 后缀表达式对应的 List
    public static List<String> parseSuffixExpreesionList(List<String> list) {
        Stack<String> s1 = new Stack<String>();
        //说明：因为 s2 这个栈，在整个转换过程中，没有 pop 操作，而且后面我们还需要逆序输出
        //因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        List<String> s2 = new ArrayList<String>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                //为数字 ,直接加入
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {     //为符号
                //当 item 的优先级小于等于 s1 栈顶运算符, 将 s1 栈顶的运算符弹出并加入到 s2 中，再次转到(4.1)
                //与 s1 中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                while (s1.size() > 0 && getValue(item) <= getValue(s1.peek())) {
                    s2.add(s1.pop());
                }
                //还需要将 item 压入栈
                s1.push(item);
            }
        }
        //将 s1 中剩余的运算符依次弹出并加入 s2
        while (s1.size() > 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //将中腏表达式放入到list中
    public static List<String> toInfixExpressionList(String expression) {
        expression.replaceAll(" ", "");
        int index = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        List<String> ls = new ArrayList<String>();
        String str;  // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到 c
        while (index < expression.length()) {
            //如果c是一个非数字,直接加入到数组
            if ((c = expression.charAt(index)) < 48 || (c = expression.charAt(index)) > 57) {
                ls.add(c + "");
                index++;    //需要后移
            } else {    //如果是一个数,需要考虑多位数
                str = "";
                while (index < expression.length() && (c = expression.charAt(index)) >= 48 && (c = expression.charAt(index)) <= 57) {
                    str += c;
                    index++;
                }
                ls.add(str);
            }
        }
        return ls;
    }

    //完成对逆波兰表达式的运算
    /*
        1)从左至右扫描，将 3 和 4 压入堆栈；
        2)遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
        3)将 5 入栈；
        4)接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
        5)将 6 入栈；
        6)最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
    */

    public static int calculation(List<String> list) {
        Stack<String> stack = new Stack<String>();
        for (String ele : list) {
            //使用正则表达式来取出数
            if (ele.matches("\\d+")) {
                stack.push(ele);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (ele.equals("+")) {
                    res = num1 + num2;
                } else if (ele.equals("-")) {
                    res = num2 - num1;
                } else if (ele.equals("*")) {
                    res = num1 * num2;
                } else if (ele.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("未知的运算符");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static List getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

}
