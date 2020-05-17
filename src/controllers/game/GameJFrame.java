package controllers.game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GameJFrame extends JFrame {

    private static final GameJFrame instance = new GameJFrame();

    private final HashMap<String, ImageIcon> MapTextures = new HashMap<>();

    private final CommandPanel commandPanel = new CommandPanel();


    private GameJFrame() {
        initComponents();

        this.setTitle("IceField");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MapTextures.put("stable", new ImageIcon("resources/stable.png"));

        this.getContentPane().setBackground(new Color(0, 148, 255));
    }

    public ImageIcon getTexture(String key)
    {
        return MapTextures.get(key);
    }

    void initComponents() {
        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.add(commandPanel);
    }

    public static GameJFrame getInstance() {
        return instance;
    }
}
