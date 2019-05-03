import Utils.grabberColour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

class captureWindow extends JFrame{
    private int pixel = 0;
    private Rectangle screenRect = new Rectangle(0, 0, 0, 0);

    captureWindow(){
        super();

        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        toFront();
        setAlwaysOnTop(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int sizeY = (int) screenSize.getHeight();

        int sizeX = width;

        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()){
            sizeX += width;
            screenRect = screenRect.union(gd.getDefaultConfiguration().getBounds());
        }

        setSize(sizeX,sizeY);
        setTitle("Colour Grabber");
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 1));
        setVisible(true);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e){}
            @Override
            public void mousePressed(MouseEvent e){}

            @Override
            public void mouseReleased(MouseEvent e) {
                int press = e.getButton();

                if (press == MouseEvent.BUTTON1){
                    grab();
                    Constants.colours.add(new grabberColour(pixel));
                    Main.startGui();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}

        });
    }

    private void grab(){
        try {
            setBackground(new Color(0, 0, 0, 0));
            Point location = MouseInfo.getPointerInfo().getLocation();
            BufferedImage capture = new Robot().createScreenCapture(screenRect);
            pixel = capture.getRGB(location.x, location.y);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
