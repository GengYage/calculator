package henu.Utils;

import henu.Action.CustomAction;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CalUtils {
    public static char partValue[] = {'A','B','C','D','E','F','G'};
    //练手静态块里面的变量，类内共享
    public static int keys = 0;
    public static JButton makeButton (String value) {
        JButton button = new JButton(value);
        button.setPreferredSize(new Dimension(50,50));
        button.setFont(new Font("微软雅黑",0,16));
        button.addActionListener(new CustomAction());
        return button;
    }
    public static JButton makeButton (String value,int width,int height) {

        JButton button = new JButton(value);
        button.setPreferredSize(new Dimension(width,height));
        button.setFont(new Font("微软雅黑",0,14));
        button.addActionListener(new CustomAction());
        return button;
    }
    //判断括号够不够数
    public static boolean judeStr(String str) {
        //纯属练手采用map
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        map.put('(',0);
        map.put(')',0);
        if(str.equals(" ")){
            return true;
        } else {
            for(int i=0;i<str.length();i++) {
                if(map.containsKey(str.charAt(i))) {
                    Integer value = map.get(str.charAt(i));
                    value++;
                    map.put(str.charAt(i),value);
                }
            }
        }
        //细节，比较值用equals，比较对象用==
        if(map.get('(') == map.get(')')) {
            return true;
        } else {
            return false;
        }
    }

    //计算方法
    //核心
    public static String getResult(String str) {
        return str+ '\n' + ArrayStack.getRes(str);
    }
}
