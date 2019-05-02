package GUI;

import Utils.grabberColour;

import javax.swing.*;
import java.awt.*;

public class colourElement extends JPanel {
    public colourElement(grabberColour c) {
        super();
        setPreferredSize(new Dimension(400, 90));
        setBackground(c.rgb);
    }
}
