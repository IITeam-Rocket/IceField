package controllers.game;

import javax.swing.*;
import java.awt.*;

public class CommandPanel extends JPanel {

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public CommandPanel() {
        initComponents();
    }

    /**
     * Initialize the components
     */
    private void initComponents() {
        this.setBounds(600, 0, 200, 600);
        this.setBackground(Color.white);

    }
}
