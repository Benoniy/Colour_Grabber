import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

class captureWindow extends JFrame{
    private ArrayList<grabberColour> colours = new ArrayList<>();
    private int pixel = 0;
    private boolean loop = true;

    captureWindow() throws AWTException, InterruptedException {
        super();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int sizeY = (int) screenSize.getHeight();

        int sizeX = width;

        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()){
            sizeX += width;
        }

        setSize(sizeX,sizeY);
        setTitle("Colour Grabber");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 1));
        setVisible(true);

        //Initialisation
        Rectangle screenRect = new Rectangle(0, 0, 0, 0);
        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
            screenRect = screenRect.union(gd.getDefaultConfiguration().getBounds());
        }

        Point location;
        BufferedImage capture;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                int e = mouseEvent.getButton();
                if (e == MouseEvent.BUTTON1){
                    colours.add(new grabberColour(pixel));
                }
                else if (e == MouseEvent.BUTTON3){
                    System.out.println("\n******************************************");
                    System.out.println("\nColours:");
                    for (grabberColour c : colours){
                        System.out.println(c.toString());
                    }
                    System.out.println("\n******************************************\n");
                }

            }
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });

        //Screen grabs every 33ms for a frame rate of 31 fps

        while (loop){
            location = MouseInfo.getPointerInfo().getLocation();
            capture = new Robot().createScreenCapture(screenRect);
            pixel = capture.getRGB(location.x, location.y);
            Thread.sleep(33);
        }
    }
}
