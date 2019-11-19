package henu.Action;

import henu.GUI.CalGUI;
import henu.Main;
import henu.Utils.CalUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextArea display = Main.getDisplay();
        String diStr = display.getText();
        display.setText(CustomAction.getDisplayStr(diStr,e.getActionCommand()));
    }
    public static String getDisplayStr(String str,String childStr) {
        String arr[] = new String[2];
        arr=str.split("\n");
        //如果是=，那么直接调用工具类里面的根据字符串计算然后返回结果
        if(childStr.equals("=")) {
            if(CalUtils.judeStr(arr[0])){
                return CalUtils.getResult(arr[0]);
            } else {
                return arr[0] + '\n' + "老哥，你括号不够数啊";
            }
        }
        //如果点击全部清除就直接恢复默认
        if(childStr == "C") {
            return " " + '\n' + " ";
        }
        //清除一个
        if(childStr.equals("<")) {
            if(!arr[0].equals(" ")) {
                if(arr[0].length()<1){
                    arr[0] = " ";
                } else {
                    arr[0] = arr[0].substring(0,arr[0].length()-1);
                }
            } else {
                arr[0] = " ";
            }
        } else if(childStr.equals("1/X")) {
            if(arr[0].equals(" ")) {
               return " "+ '\n' + "老哥，你分子呢？";
            } else {
                arr[0] = "1/(" + arr[0]+")";
            }
        } else { //正常的添加
            if(arr[0].equals(" ")) {
                arr[0] = childStr;
            } else {
                arr[0] += childStr;
            }
        }
        arr[1] = childStr;
       return arr[0]+'\n'+arr[1];
    }
}
