package henu;

import henu.GUI.CalGUI;

import javax.swing.*;

public class Main {
    private static CalGUI calGUI;
    public static void main(String[] args) {
        JFrame frame = new JFrame("计算器");
        calGUI = new CalGUI();
        frame.add(calGUI);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(300,300,250,300);
        frame.setResizable(false);
    }
    public static JTextArea getDisplay() {
        return calGUI.getDisplay();
    }
}
