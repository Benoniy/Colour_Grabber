import Utils.File_Chooser;
import javax.swing.*;
import java.io.File;


public class Main {
    private static JFrame current;

    public static void main(String[] args) {
        current = new MyFrame("Colour Grabber");
    }

    public static void startCap(){
        current.dispose();
        current = new Capture_Window();
    }

    public static void startIMGCap(){
        current.dispose();
        try {
            SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                new File_Chooser("i");
                File dir = File_Chooser.getFile();

                current = new Image_Window(dir);
            });


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startGui(){
        current.dispose();
        current = new MyFrame("Colour Grabber");
    }
}
