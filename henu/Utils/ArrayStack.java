package henu.Utils;

import java.util.*;

public class ArrayStack {
    //将字符串拆为数字，运算符,存入list
    public static List getExp(String exp) {
        List list = new ArrayList();
        int start = 0;
        int end = 0;
        for(int i = 0;i<exp.length();i++) {
            if(ArrayStack.isOpeChar(exp.charAt(i))) {
                if(start != end) {
                    list.add(exp.substring(start,end));
                    start = end = i+1;
                }
                if(start == end && end == i) {
                    start=end=i+1; //避免多个运算符在一块的情况
                }
                list.add(exp.charAt(i));
            } else {
                end++;
            }
            if(i == exp.length()-1 && !ArrayStack.isOpeChar(exp.charAt(exp.length()-1))) {
                list.add(exp.substring(start,end));
            }
        }
        return list;
    }
    //返回运算符优先级,用数字表示,数字越大,优先级越高
    public static int getPriority(double opeChar) {
        if((int)opeChar == '(') {
            return 0;
        }else if((int)opeChar == '*' ||
                (int)opeChar == '/' || 
                (int)opeChar == '%') {
            return 2;
        } else if((int)opeChar == '√'){
            return 3;
        } else {
            //+ -
            return 1;
        }
    }
    //得出优先级
    public static int getPriority(int opeChar) {
        if(opeChar == '(') {
            return 0;
        }else if(opeChar == '*' ||
                opeChar == '/') {
            return 2;
        } else if(opeChar == '√'){
            return 3;
        } else {
            //+ -
            return 1;
        }
    }
    //计算逆波兰表达式
    public static List getPolandNotation(String exp) {
        List list;
        List ls = new ArrayList();
        list = ArrayStack.getExp(exp);
        //使用java定义的stack
        Stack<Character> opeStack = new Stack<Character>();
        for(int i=0;i<list.size();i++) {
            if(list.get(i) instanceof Character) {
                //是运算符
                if(list.get(i).equals(')')) {
                    for(int j=0;j<opeStack.size();j++) {
                        if(!opeStack.peek().equals('(')){
                            ls.add(opeStack.pop());
                        } else {
                            opeStack.pop();
                        }
                    }
                } else if(opeStack.isEmpty() ||
                        (char)list.get(i)=='(' ||
                        ArrayStack.getPriority(opeStack.peek()) <= ArrayStack.getPriority((char)list.get(i))) {
                    opeStack.push((char)list.get(i));
                } else if(ArrayStack.getPriority(opeStack.peek()) > ArrayStack.getPriority((char)list.get(i))){
                    ls.add(opeStack.pop());
                    opeStack.push((char)list.get(i));
                }
            } else {
                ls.add(list.get(i));
            }
            if(i == list.size()-1) {
                while (!opeStack.isEmpty() && opeStack.peek()!='(') {
                    ls.add(opeStack.pop());
                }
            }
        }
        return ls;
    }
    //判断是否为运算符
    public static boolean isOpeChar(char val) {
        return val=='+' || val=='-' || val=='*' || val=='/' || val=='√' || val=='(' || val==')' || val=='%';
    }
    //运算
    public static double cal(double firstNum, double secondNum, char opeChar) {
        double res = 0;//保存结果
        switch (opeChar) {
            case '+':
                res = firstNum+secondNum;
                break;
            case '-':
                res = secondNum-firstNum;
                break;
            case '*':
                res = firstNum*secondNum;
                break;
            case '/':
                res = secondNum/firstNum;
                break;
            case '√':
                res = Math.sqrt(firstNum);
                break;
            case '%':
            	res = secondNum%firstNum;
            default:
                break;
        }
        return res;
    }
    public static double getRes(String str) {
        System.out.println(ArrayStack.getExp(str));
        System.out.println(ArrayStack.getPolandNotation(str));
        List list = ArrayStack.getPolandNotation(str);
        Stack<Double> stack = new Stack<Double>();
        double firstNum = 0;
        double secondNum = 0;
        double res = 0;
        for(int i=0;i<list.size();i++) {
            if(list.get(i) instanceof Character) {
                if(list.get(i).equals('√')) {
                    firstNum = stack.pop();
                    secondNum = 0;
                } else {
                    firstNum = stack.pop();
                    secondNum = stack.pop();
                }
                res = cal(firstNum,secondNum,(char)list.get(i));
                stack.push(res);
            } else {
                stack.push(Double.parseDouble((String) list.get(i)));
            }
        }
        return stack.pop();
    }
}