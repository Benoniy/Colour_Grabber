import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class captureWindow extends JFrame{
    public captureWindow(int sizeX, int sizeY) throws AWTException, InterruptedException {
        super();
        setSize(sizeX,sizeY);
        setTitle("Colour Grabber");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 1));
        setVisible(true);


        //Initialisation
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        Point location;
        BufferedImage capture;
        final int[] pixel = {0};

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

                //error because of this
                Constants.colours.add(new grabberColour(pixel[0]));
                int len = Constants.colours.size();
                System.out.println(Constants.colours.get(len - 1).red + ", " + Constants.colours.get(len - 1).green +
                        ", " + Constants.colours.get(len - 1).blue);
            }
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });

        //Screen grabs every 33ms for a frame rate of 31 fps
        boolean loop = true;
        while (loop){
            location = MouseInfo.getPointerInfo().getLocation();
            capture = new Robot().createScreenCapture(screenRect);
            pixel[0] = capture.getRGB(location.x, location.y);
            Thread.sleep(33);
        }
    }
}
