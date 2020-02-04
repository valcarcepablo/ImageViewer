package control; 

import java.awt.event.ActionEvent;
import view.ui.ImagePanel;

public class PreviousImageCommand implements Command {

    private final ImagePanel imagePanel;

    public PreviousImageCommand(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    @Override
    public void execute() {
        imagePanel.setImage(imagePanel.getImage().getPrev());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}