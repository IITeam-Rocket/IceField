package controllers.game;

import controllers.view.MapPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GameJFrame extends JFrame {

    private static final GameJFrame instance = new GameJFrame();

    private final HashMap<String, ImageIcon> MapTextures = new HashMap<>();

    private final CommandPanel commandPanel = new CommandPanel();


    private GameJFrame() {
        initTextures();
        initComponents();


        this.setTitle("IceField");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setSize(imageLabel.getPreferredSize());
        this.setLocationRelativeTo(null);

        this.getContentPane().setBackground(new Color(0, 148, 255));
    }

    public void initTextures()
    {
        for(int i = 0; i < 7; i++)
        {
            MapTextures.put("stable_" + String.valueOf(i), new ImageIcon("resources/stable_" + String.valueOf(i) + ".png"));
            MapTextures.put("stable_" + String.valueOf(i) + "_iglu", new ImageIcon("resources/stable_" + String.valueOf(i) + "_iglu.png"));
            MapTextures.put("stable_" + String.valueOf(i) + "_tent", new ImageIcon("resources/stable_" + String.valueOf(i) + "_tent.png"));
        }
        MapTextures.put("water", new ImageIcon("resources/water.png"));
        MapTextures.put("stable", new ImageIcon("resources/stable.png"));
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

    public void paint(Graphics g)
    {
        super.paint(g);
        g.translate(this.getInsets().left + 30, this.getInsets().top + 30);

        MapPresenter.getInstance().paint(g);

        g.translate(- this.getInsets().left - 30, - this.getInsets().top - 30);
    }

    public static GameJFrame getInstance() {
        return instance;
    }
}
