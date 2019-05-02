package GUI;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    Font font = new Font("SansSerif", Font.BOLD, 13);

    public MyLabel(String text){
        super(text);
        setFont(font);
    }
}
