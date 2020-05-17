package controllers.game;

import controllers.view.MapPresenter;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class GameJFrame extends JFrame {

    private static final GameJFrame instance = new GameJFrame();

    private final HashMap<String, ImageIcon> MapTextures = new HashMap<>();

    private final CommandPanel commandPanel = new CommandPanel();

    private final Game game = new Game();
    private final CommandInterpreter commandInterpreter = new CommandInterpreter();

    private Tile activeTile = null;

    public Game getGame() {
        return game;
    }

    public void setActiveTile(Tile t) {
        activeTile = t;
    }

    private GameJFrame() {
        initTextures();
        initComponents();

        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                repaint();
            }

            public void windowIconified(WindowEvent e) {
                repaint();
            }

            public void windowDeiconified(WindowEvent e) {
                repaint();
            }

            public void windowActivated(WindowEvent e) {
                repaint();
            }

            public void windowDeactivated(WindowEvent e) {
                repaint();
            }

            public void windowStateChanged(WindowEvent e) {
                repaint();
            }

            public void windowGainedFocus(WindowEvent e) {
                repaint();
            }
        });

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

        MapTextures.put("bear", new ImageIcon("resources/bear.png"));
        MapTextures.put("bear_active", new ImageIcon("resources/bear_active.png"));
        MapTextures.put("eskimo", new ImageIcon("resources/eskimo.png"));
        MapTextures.put("eskimo_active", new ImageIcon("resources/eskimo_active.png"));
        MapTextures.put("researcher", new ImageIcon("resources/researcher.png"));
        MapTextures.put("researcher_active", new ImageIcon("resources/researcher_active.png"));



}

    public void OutputToTextBox(String text) {
        this.text.setText(text);
    }

    public ImageIcon getTexture(String key)
    {
        return MapTextures.get(key);
    }

    private JTextArea text = new JTextArea("Csapattagok:\n  Ábrahám Dániel\n  Józsa György Bence\n  Kovács Marcell\n  Matyasi Lilla Nóra\n  Tóth Máté\n\nKonzulens:\n  Dr. Goldschmidt Balázs");
    private JTextArea team = new JTextArea("team_rocket\n    v1.0");
    private JLabel io = new JLabel("IO:");
    private JTextField textbox = new JTextField("Filename Textbox");
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
        this.setIgnoreRepaint(true);

        commandPanel.setBounds(545,0,255, 600);

        io.setVisible(true);
        commandPanel.add(io);

        textbox.setVisible(true);
        commandPanel.add(textbox);

        load.setVisible(true);
        commandPanel.add(load);

        save.setVisible(true);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.NextCharacter();
            }
        });
        commandPanel.add(next);

        move.setVisible(true);
        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.Move(activeTile);
                activeTile = null;
            }
        });
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

        text.setVisible(true);
        commandPanel.add(text);

        team.setVisible(true);
        commandPanel.add(team);
    }

    public void paint(Graphics g)
    {
        io.setBounds(10,10,20, 15);
        textbox.setBounds(5,30,235, 20);
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
        text.setBounds(5,300, 200, 220);
        team.setBounds(90,520, 200, 230);
        super.paint(g);

        g.translate(this.getInsets().left + 30, this.getInsets().top + 30);

        MapPresenter.getInstance().paint(g);

        g.translate(- this.getInsets().left - 30, - this.getInsets().top - 30);

        MapPresenter.getInstance().afterDraw();
    }

    public static GameJFrame getInstance() {
        return instance;
    }

    public void showItemDialog(String itemName) {
        ItemDialog dialog = new ItemDialog(this, itemName);
    }
}
