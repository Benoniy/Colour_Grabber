import Utils.grabberColour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

class imageWindow extends JFrame{
    private int pixel = 0;
    private Rectangle screenRect = new Rectangle(0, 0, 1920, 1080);

    imageWindow(File imgFile){
        super();
        try {
            if (!imgFile.exists()){
                throw new FileNotFoundException();
            }
            this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            toFront();
            setAlwaysOnTop(true);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) screenSize.getWidth();
            int sizeY = (int) screenSize.getHeight();

            int sizeX = width;

            setSize(sizeX, sizeY);
            setTitle("Colour Grabber");
            setBackground(Color.BLACK);
            setVisible(true);

            JPanel content = new JPanel();
            Icon img = new ImageIcon(imgFile.getPath(), null);
            JLabel pic = new JLabel(img);
            content.add(pic);



            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    int press = e.getButton();

                    if (press == MouseEvent.BUTTON1) {
                        grab();
                        Constants.colours.add(new grabberColour(pixel));
                        Main.startGui();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }


            });
            this.add(content);
            this.pack();
        }
        catch (Exception ex){
            Main.startGui();
        }
    }

    private void grab(){
        try {
            Point location = MouseInfo.getPointerInfo().getLocation();
            BufferedImage capture = new Robot().createScreenCapture(screenRect);
            pixel = capture.getRGB(location.x, location.y);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
