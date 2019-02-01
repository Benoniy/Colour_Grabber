import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public Window(int sizeX, int sizeY){
        super();
        setSize(sizeX,sizeY);
        setTitle("Colour Grabber");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 1));
        setVisible(true);
    }
}
