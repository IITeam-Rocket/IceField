package controllers.game;

import javax.swing.*;
import java.awt.*;

public class ItemDialog extends JDialog {
    private final JButton buttonOK = new JButton("OK");
    private final JLabel foundLabel = new JLabel("You have found an item!");
    private final JLabel itemLabel = new JLabel();
    private final JPanel buttonPanel = new JPanel();
    private final JPanel labelPanel = new JPanel();
    private final JPanel contentPane = new JPanel();

    /**
     * Creates a modeless dialog with the specified {@code Frame}
     * as its owner and an empty title. If {@code owner}
     * is {@code null}, a shared, hidden frame will be set as the
     * owner of the dialog.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by {@code JComponent.getDefaultLocale}.
     * <p>
     * NOTE: This constructor does not allow you to create an unowned
     * {@code JDialog}. To create an unowned {@code JDialog}
     * you must use either the {@code JDialog(Window)} or
     * {@code JDialog(Dialog)} constructor with an argument of
     * {@code null}.
     *
     * @param owner the {@code Frame} from which the dialog is displayed
     *
     * @throws HeadlessException if {@code GraphicsEnvironment.isHeadless()}
     *                           returns {@code true}.
     * @see GraphicsEnvironment#isHeadless
     * @see JComponent#getDefaultLocale
     */
    public ItemDialog(Frame owner, String itemName) {
        super(owner);
        initComponents();
        itemLabel.setText("Item: " + itemName);
        pack();
        this.setMinimumSize(new Dimension(200, 150));
    }

    private void initComponents() {
        this.add(contentPane);
        contentPane.setLayout(new GridLayout(2, 1));
        contentPane.add(labelPanel);
        contentPane.add(buttonPanel);
        buttonPanel.add(buttonOK);
        labelPanel.setLayout(new GridLayout(2, 1));
        labelPanel.add(foundLabel);
        foundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(itemLabel);
        itemLabel.setHorizontalAlignment(SwingConstants.CENTER);

        buttonOK.addActionListener(e -> onOK());
        setVisible(true);
        setLocationRelativeTo(getOwner());
    }

    private void onOK() {
        dispose();
    }
}
