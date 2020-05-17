package controllers.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EndGameDialog extends JDialog {

    private final JButton buttonOK = new JButton("OK");
    private final JLabel GameOverLabel = new JLabel("Game has ended!");
    private final JPanel buttonPanel = new JPanel();
    private final JPanel labelPanel = new JPanel();
    private final JPanel contentPane = new JPanel();

    /**
     * Creates a modeless dialog with the specified title and
     * with the specified owner frame.  If {@code owner}
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
     * @param title the {@code String} to display in the dialog's
     *              title bar
     * @throws HeadlessException if {@code GraphicsEnvironment.isHeadless()}
     *                           returns {@code true}.
     * @see GraphicsEnvironment#isHeadless
     * @see JComponent#getDefaultLocale
     */
    public EndGameDialog(Frame owner, String title) {
        super(owner, title);
        initComponents();
        pack();
        owner.setEnabled(false);
        this.setMinimumSize(new Dimension(200, 150));

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void initComponents() {
        this.add(contentPane);
        contentPane.setLayout(new GridLayout(2, 1));
        contentPane.add(labelPanel);
        contentPane.add(buttonPanel);
        buttonPanel.add(buttonOK);
        labelPanel.setLayout(new GridLayout(2, 1));
        labelPanel.add(GameOverLabel);
        GameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);

        buttonOK.addActionListener(e -> onOK());
        setVisible(true);
        setLocationRelativeTo(getOwner());
    }

    private void onOK() {
        System.exit(0);
    }
}
