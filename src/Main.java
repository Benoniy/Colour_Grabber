import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AWTException, IOException {
        Point location = MouseInfo.getPointerInfo().getLocation();
        System.out.println(location.toString());

        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        int c = capture.getRGB(location.x, location.y);
        int[] RGB = RGBconvert(c);

        System.out.println(RGB[0] + ", " + RGB[1] + ", " + RGB[2]);
    }

    static int[] RGBconvert(int c){
        int red = (c >> 16) & 0xff;
        int green = (c >> 8) & 0xff;
        int blue = (c) & 0xff;
        System.out.println("R: " + red + ", G: " + green + ", B: " + blue);
        return new int[]{red,green,blue};
    }
}
