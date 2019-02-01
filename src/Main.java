import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {
        Window frame = new Window(1920, 1080);

        //Initialisation
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        Point location;
        BufferedImage capture;
        final int[] pixel = {0};

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                grabberColour c = new grabberColour(pixel[0]);
                System.out.println(c.red + ", " + c.green + ", " + c.blue);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
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
