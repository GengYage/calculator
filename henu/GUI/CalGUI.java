package henu.GUI;

import henu.Utils.CalUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CalGUI extends JPanel {
    JPanel body;
    JTextArea display;
    JPanel keyboard;
    JPanel bottom;
    JPanel botLeft;
    JPanel botRight;
    public CalGUI() {
        setLayout(new BorderLayout());
        body = new JPanel();
        display = new JTextArea(2,100);
        //display.setEnabled(false);
        //关闭自动换行
        display.setLineWrap(false);
        //显示为空
        display.setText(" "+"\n"+" ");
        body.setLayout(new BorderLayout());
        body.add(display, BorderLayout.NORTH);
        keyboard = new JPanel();
        keyboard.setBorder(new EmptyBorder(0, -5, 0, -5));
        keyboard.setLayout(new GridLayout(3,5,0,0));
        keyboard.add(CalUtils.makeButton("<"));
        keyboard.add(CalUtils.makeButton("C"));
        keyboard.add(CalUtils.makeButton("("));
        keyboard.add(CalUtils.makeButton(")"));
        keyboard.add(CalUtils.makeButton("√"));
        keyboard.add(CalUtils.makeButton("7"));
        keyboard.add(CalUtils.makeButton("8"));
        keyboard.add(CalUtils.makeButton("9"));
        keyboard.add(CalUtils.makeButton("/"));
        keyboard.add(CalUtils.makeButton("%"));
        keyboard.add(CalUtils.makeButton("4"));
        keyboard.add(CalUtils.makeButton("5"));
        keyboard.add(CalUtils.makeButton("6"));
        keyboard.add(CalUtils.makeButton("*"));
        keyboard.add(CalUtils.makeButton("1/X"));
        body.add(keyboard, BorderLayout.CENTER);

        bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        keyboard.setBorder(new EmptyBorder(0, -5, 0, -5));
        bottom.add(CalUtils.makeButton("=",50,100), BorderLayout.EAST);
        body.add(bottom, BorderLayout.SOUTH);

        botLeft = new JPanel();
        botLeft.setLayout(new BorderLayout());
        botLeft.add(CalUtils.makeButton("1"), BorderLayout.EAST);
        botLeft.add(CalUtils.makeButton("2"), BorderLayout.WEST);
        botLeft.add(CalUtils.makeButton("0",100,50), BorderLayout.SOUTH);
        bottom.add(botLeft, BorderLayout.WEST);

        botRight = new JPanel();
        botRight.setLayout(new GridLayout(2,2));
        botRight.add(CalUtils.makeButton("3"));
        botRight.add(CalUtils.makeButton("-"));
        botRight.add(CalUtils.makeButton("."));
        botRight.add(CalUtils.makeButton("+"));
        bottom.add(botRight, BorderLayout.CENTER);
        add(body);
    }

    public JTextArea getDisplay() {
        return this.display;
    }
}
