import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AWTException, IOException {
        Point location = MouseInfo.getPointerInfo().getLocation();
        System.out.println(location.toString());

        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
        int pixel = capture.getRGB(location.x, location.y);

        grabberColour c = new grabberColour(pixel);

        System.out.println(c.red + ", " + c.green + ", " + c.blue);
    }
}
