package controllers.game;

import controllers.view.Listeners.MouseHandler;

import javax.swing.*;

public class GameJFrame extends JFrame {

    private static final GameJFrame instance = new GameJFrame();

    private GameJFrame() {
        initComonents();
    }

    void initComonents() {
        JButton b = new JButton("");
        b.setBounds(130, 100, 60, 60);
        b.addActionListener(new MouseHandler());
        this.add(b);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
    }

    public static GameJFrame getInstance() {
        return instance;
    }
}
