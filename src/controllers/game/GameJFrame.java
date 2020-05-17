package controllers.game;

import controllers.RandomControllerUtil;
import controllers.view.MapPresenter;
import models.Environment;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class GameJFrame extends JFrame {

    /**
     * Attributes
     */
    private static final GameJFrame instance = new GameJFrame();

    private final HashMap<String, ImageIcon> MapTextures = new HashMap<>();

    private final CommandPanel commandPanel = new CommandPanel();

    private final Game game = new Game();

    private BufferedImage image;

    private final JTextArea text = new JTextArea("Csapattagok:\n  Ábrahám Dániel\n  Józsa György Bence\n  Kovács Marcell\n  Matyasi Lilla Nóra\n  Tóth Máté\n\nKonzulens:\n  Dr. Goldschmidt Balázs");
    private final JTextArea debug = new JTextArea("Debug info");
    private final JTextArea team = new JTextArea("team_rocket\n      v1.0");
    private final JLabel io = new JLabel("IO:");
    private final JTextField textBox = new JTextField("Filename Textbox");
    private final JButton load = new JButton("Load");
    private final JButton save = new JButton("Save");
    private final JLabel randomness = new JLabel("Randomness:   ");
    private final JButton random = new JButton("Random Off");
    private final JButton weather = new JButton("Simulate Weather");
    private final JLabel gameplay = new JLabel("Gameplay:");
    private final JButton special = new JButton("Use Special Ability");
    private final JButton craft = new JButton("Craft Signal Flare");
    private final JButton rescue = new JButton("rescue");
    private final JButton snow = new JButton("Clear Snow");
    private final JButton unbury = new JButton("unBury");
    private final JButton move = new JButton("move");
    private final JButton next = new JButton("Next Character");

    private Tile activeTile = null;


    /**
     * Get the Game Object
     * @return current Game object
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set active Tile
     * @param t Tile to set as active
     */
    public void setActiveTile(Tile t) {
        activeTile = t;
    }

    /**
     * Private constructor this is a Singleton class
     */
    private GameJFrame() {
        this.setContentPane(new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, 800, 600, this);
            }
        });

        initTextures();
        initComponents();

        this.addWindowListener(new WindowAdapter() {
            /**
             * Window event
             * @param e Event to process
             */
            public void windowOpened(WindowEvent e) {
                repaint();
            }

            /**
             * Window event
             * @param e Event to process
             */
            public void windowIconified(WindowEvent e) {
                repaint();
            }

            /**
             * Window event
             * @param e Event to process
             */
            public void windowDeiconified(WindowEvent e) {
                repaint();
            }

            /**
             * Window event
             * @param e Event to process
             */
            public void windowActivated(WindowEvent e) {
                repaint();
            }

            /**
             * Window event
             * @param e Event to process
             */
            public void windowDeactivated(WindowEvent e) {
                repaint();
            }

            /**
             * Window event
             * @param e Event to process
             */
            public void windowStateChanged(WindowEvent e) {
                repaint();
            }

            /**
             * Window event
             * @param e Event to process
             */
            public void windowGainedFocus(WindowEvent e) {
                repaint();
            }
        });

        this.setTitle("IceField");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * Initialize textures
     */
    public void initTextures() {

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

    /**
     * Set the character out info on the screen
     * @param text Text to set it to
     */
    public void characterOutInfo(String text) {
        this.text.setText(text);
        this.text.grabFocus();
    }

    /**
     * Set the output info on the screen
     * @param text Text to set it to
     */
    public void outputToTextBox(String text) {
        this.debug.setText(text);
        this.debug.grabFocus();
    }

    /**
     * Get texture
     * @param key Kex to get Texture with
     * @return The found Texture
     */
    public ImageIcon getTexture(String key)
    {
        return MapTextures.get(key);
    }

    /**
     * Initialize the components
     */
    private void initComponents() {
        this.setResizable(false);
        this.setSize(930, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.add(commandPanel);
        this.setIgnoreRepaint(true);

        commandPanel.setBounds(600, 0, 315, 600);

        io.setVisible(true);
        commandPanel.add(io);

        textBox.setVisible(true);
        commandPanel.add(textBox);

        load.setVisible(true);
        load.addActionListener(e -> {
            Environment.serializeRead(textBox.getText());
            MapPresenter.getInstance().update();
        });
        commandPanel.add(load);

        save.setVisible(true);
        save.addActionListener(e -> {Environment.serializeWrite(textBox.getText());
                    MapPresenter.getInstance().update();});
        commandPanel.add(save);

        randomness.setVisible(true);
        commandPanel.add(randomness);

        random.setVisible(true);
        random.addActionListener(e -> {
            game.random();
            if (random.getText().equals("Random Off"))
                random.setText("Random On");
            else if (random.getText().equals("Random On"))
                random.setText("Random Off");
            MapPresenter.getInstance().update();
        });
        commandPanel.add(random);

        weather.setVisible(true);
        weather.setEnabled(false);
        weather.addActionListener(e -> {game.simulateWeather();
                    MapPresenter.getInstance().update();
        });
        commandPanel.add(weather);

        gameplay.setVisible(true);
        commandPanel.add(gameplay);

        next.setVisible(true);
        next.addActionListener(e -> {
            game.nextCharacter();
                    MapPresenter.getInstance().update();
        });
        commandPanel.add(next);

        move.setVisible(true);
        move.addActionListener(e -> {
            if (activeTile != null) {
                game.move(activeTile);
                activeTile = null;
            }
        });
        commandPanel.add(move);

        unbury.setVisible(true);
        unbury.addActionListener(e -> {
            game.unBury();
            MapPresenter.getInstance().update();
        });
        commandPanel.add(unbury);

        snow.setVisible(true);
        snow.addActionListener(e -> {
            game.clearSnow();
            MapPresenter.getInstance().update();
        });
        commandPanel.add(snow);

        rescue.setVisible(true);
        rescue.addActionListener(e -> {
            if (activeTile != null) {
                game.rescue(activeTile);
                activeTile = null;
            }
            MapPresenter.getInstance().update();
        });
        commandPanel.add(rescue);

        craft.setVisible(true);
        commandPanel.add(craft);
        craft.addActionListener(e -> {
            game.craftSignalFlare();
                    activeTile = null;
                    MapPresenter.getInstance().update();
                }
        );


        special.setVisible(true);
        special.addActionListener(e -> {
            if (activeTile != null) {
                game.useSpecial(activeTile);
                activeTile = null;
            }
            MapPresenter.getInstance().update();
        });
        commandPanel.add(special);

        text.setVisible(true);
        text.setEditable(false);
        commandPanel.add(text);

        debug.setVisible(true);
        debug.setEditable(false);
        commandPanel.add(debug);
        team.setVisible(true);
        team.setEditable(false);
        commandPanel.add(team);

        RandomControllerUtil.addListener(x -> weather.setEnabled(!x));
    }

    /**
     * Create the background
     */
    public void createBackground() {

        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics graph = image.createGraphics();
        graph.setColor(new Color(0, 148, 255));
        graph.fillRect(0, 0, 800, 600);
        graph.setColor(new Color(0, 0, 0));
        graph.translate(30, 30);
        MapPresenter.getInstance().paint(graph);
    }

    /**
     * Paint the screen
     * @param g Graphics to use to draw
     */
    public void paint(Graphics g) {

        io.setBounds(10, 10, 20, 15);
        textBox.setBounds(5, 30, 305, 20);

        load.setBounds(5, 60, 150, 20);
        save.setBounds(160, 60, 150, 20);

        randomness.setBounds(10, 90, 150, 15);

        random.setBounds(5, 110, 150, 20);
        weather.setBounds(160, 110, 150, 20);

        gameplay.setBounds(10, 140, 150, 15);

        next.setBounds(5,160, 150, 20);
        move.setBounds(160,160, 150, 20);
        unbury.setBounds(5,190, 150, 20);
        snow.setBounds(160,190, 150, 20);
        rescue.setBounds(5,220, 150, 20);
        craft.setBounds(160,220, 150, 20);
        special.setBounds(80,250, 150, 20);


        text.setBounds(5,280, 400, 145);
        debug.setBounds(5, 430, 400,90);
        team.setBounds(130,520, 400, 230);

        createBackground();
        super.paint(g);
    }

    /**
     * Singleton instance
     * @return Get the instance
     */
    public static GameJFrame getInstance() {
        return instance;
    }

    /**
     * Show an item dialog
     * @param itemName Name of the Item
     */
    public void showItemDialog(String itemName) {
        ItemDialog dialog = new ItemDialog(this, itemName);
    }

    /**
     * Show end game dialog
     */
    public void showEndGameDialog() {
        EndGameDialog dialog = new EndGameDialog(this, "End Game");
    }

    /**
     * Show win game dialog
     */
    public void showWinGameDialog() {
        EndGameDialog dialog = new EndGameDialog(this, "Game Won");
    }

}
