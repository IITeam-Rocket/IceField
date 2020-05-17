package controllers.game;

import controllers.view.Listeners.MouseHandler;

import javax.swing.*;
import java.util.HashMap;

public class GameJFrame extends JFrame {

    private static final GameJFrame instance = new GameJFrame();

    private HashMap<String, ImageIcon> MapTextures;


    private GameJFrame() {
        initComponents();

        this.setTitle("IceField");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MapTextures = new HashMap<String, ImageIcon>();
        MapTextures.put("stable", new ImageIcon("resources/stable.png"));
    }

    public ImageIcon getTexture(String key)
    {
        return MapTextures.get(key);
    }

    void initComponents() {
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
