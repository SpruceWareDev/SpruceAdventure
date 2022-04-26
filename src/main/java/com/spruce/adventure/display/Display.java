package com.spruce.adventure.display;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    private Canvas canvas;

    public static int startWidth, startHeight;

    public Display(String title, int width, int height){
        createDisplay(title, width, height);
        startWidth = width;
        startHeight = height;
    }

    private void createDisplay(String title, int width, int height){
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        add(canvas);
        pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return this;
    }
}
