package controllers.game;

import controllers.view.Listeners.MouseHandler;

import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame() {
        initComonents();
    }

    void initComonents() {
        JButton b = new JButton("click");
        b.addMouseListener(new MouseHandler());
        this.add(b);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
    }
}
