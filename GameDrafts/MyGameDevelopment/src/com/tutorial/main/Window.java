package com.tutorial.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LENOVO on 4/4/2017.
 */
public class Window extends Canvas {

    private static final long serialVersionUID = 240840600533728354L;
    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        // start at the middle of the screen
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
