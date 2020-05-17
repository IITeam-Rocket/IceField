package controllers.game;

import javax.swing.*;
import java.awt.*;

public class ItemDialog extends JDialog {
    private final JButton buttonOK = new JButton("OK");
    private final JLabel foundLabel = new JLabel("You have found an item!");
    private final JLabel itemLabel = new JLabel();

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

    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(buttonOK, BorderLayout.SOUTH);
        buttonOK.setContentAreaFilled(false);
    }
}
