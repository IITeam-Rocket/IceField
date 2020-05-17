package controllers.game;

import controllers.view.MapPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameJFrame extends JFrame {

    private static final GameJFrame instance = new GameJFrame();

    private final HashMap<String, ImageIcon> MapTextures = new HashMap<>();

    private final CommandPanel commandPanel = new CommandPanel();

    private final Game game = new Game();
    private final CommandInterpreter commandInterpreter = new CommandInterpreter();

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
            MapTextures.put("stable_" + i, new ImageIcon("resources/stable_" + i + ".png"));
            MapTextures.put("stable_" + i + "_iglu", new ImageIcon("resources/stable_" + i + "_iglu.png"));
            MapTextures.put("stable_" + i + "_tent", new ImageIcon("resources/stable_" + i + "_tent.png"));
        }
        MapTextures.put("water", new ImageIcon("resources/water.png"));
        MapTextures.put("stable", new ImageIcon("resources/stable.png"));
    }

    public ImageIcon getTexture(String key)
    {
        return MapTextures.get(key);
    }

    private JTextArea team= new JTextArea("Csapattagok:\nÁbrahám Dániel\nJózsa György Bence\nKovács Marcell\nMatyasi Lilla Nóra\nTóth Máté\n\nKonzulens:\nDr. Goldschmidt Balázs\n \nteam_rocket\nv1.0");
    private JLabel io = new JLabel("IO:");
    private JTextField text = new JTextField("Filename Textbox");
    private JButton load = new JButton("Load");
    private JButton save = new JButton("Save");
    private JLabel randomness = new JLabel("Randomness:");
    private JButton random = new JButton("Random Off");
    private JButton weather = new JButton("Simulate Weather");
    private JLabel gameplay = new JLabel("Gameplay:");
    private JButton special = new JButton("Use Special Ability");
    private JButton craft = new JButton("Craft Signal Flare");
    private JButton rescue = new JButton("Rescue");
    private JButton snow = new JButton("Clear Snow");
    private JButton unbury = new JButton("Unbury");
    private JButton move = new JButton("Move");
    private JButton next = new JButton("Next Character");

    void initComponents() {
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.add(commandPanel);

        commandPanel.setBounds(545,0,255, 600);

        io.setVisible(true);
        commandPanel.add(io);

        text.setVisible(true);
        commandPanel.add(text);

        load.setVisible(true);
        commandPanel.add(load);

        save.setVisible(true);
        commandPanel.add(save);

        randomness.setVisible(true);
        commandPanel.add(randomness);

        random.setVisible(true);
        commandPanel.add(random);

        weather.setVisible(true);
        commandPanel.add(weather);

        gameplay.setVisible(true);
        commandPanel.add(gameplay);

        next.setVisible(true);
        commandPanel.add(next);

        move.setVisible(true);
        commandPanel.add(move);

        unbury.setVisible(true);
        commandPanel.add(unbury);

        snow.setVisible(true);
        commandPanel.add(snow);

        rescue.setVisible(true);
        commandPanel.add(rescue);

        craft.setVisible(true);
        commandPanel.add(craft);

        special.setVisible(true);
        commandPanel.add(special);

        team.setVisible(true);
        commandPanel.add(team);
    }

    public void paint(Graphics g)
    {
        io.setBounds(10,10,20, 15);
        text.setBounds(5,30,235, 20);
        load.setBounds(5,60, 120, 20);
        save.setBounds(130,60, 120, 20);
        randomness.setBounds(10,90,150, 15);
        random.setBounds(5,110, 120, 20);
        weather.setBounds(130,110, 120, 20);
        gameplay.setBounds(10,140,150, 15);
        next.setBounds(5,160, 120, 20);
        move.setBounds(130,160, 120, 20);
        unbury.setBounds(5,190, 120, 20);
        snow.setBounds(130,190, 120, 20);
        rescue.setBounds(5,220, 120, 20);
        craft.setBounds(130,220, 120, 20);
        special.setBounds(60,250, 135, 20);
        team.setBounds(5,300, 200, 200);
        super.paint(g);

        g.translate(this.getInsets().left + 30, this.getInsets().top + 30);

        MapPresenter.getInstance().paint(g);

        g.translate(- this.getInsets().left - 30, - this.getInsets().top - 30);

        MapPresenter.getInstance().afterDraw();
    }

    public static GameJFrame getInstance() {
        return instance;
    }
}
