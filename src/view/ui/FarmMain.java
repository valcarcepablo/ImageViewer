package view.ui;

import control.LoadImageCommand;
import control.PreviousImageCommand;
import control.NextImageCommand;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FarmMain extends JFrame {

    private ImagePanel imagePanel;

    public FarmMain() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Image Viewer");
        setLayout(new BorderLayout());
        createComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {
        getContentPane().add(createImagePanel(), CENTER);
        getContentPane().add(createMenuPanel(), NORTH);
        getContentPane().add(createImageBrowsingMenu(), SOUTH);
    }

    private ImagePanel createImagePanel() {
        imagePanel = new ImagePanel();
        return imagePanel;
    }

    private PanelOpenMenu createMenuPanel() {
        PanelOpenMenu openMenu = new PanelOpenMenu(createLoadImageCommand());
        return openMenu;
    }

    private PanelBrowser createImageBrowsingMenu() {
        PanelBrowser browsingPanel = new PanelBrowser(createButtonsCommands());
        return browsingPanel;
    }

    private ActionListener[] createButtonsCommands() {
        return new ActionListener[]{
            new PreviousImageCommand(imagePanel),
            new NextImageCommand(imagePanel)
        };
    }

    private ActionListener[] createLoadImageCommand() {
        return new ActionListener[]{
            new LoadImageCommand(imagePanel)
        };
    }
}