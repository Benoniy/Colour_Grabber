import javax.swing.*;


public class Main {
    private static JFrame current;

    public static void main(String[] args) {
        current = new MyFrame("Colour Grabber");
    }

    public static void startCap(){
        current.dispose();
        try {
            current = new captureWindow();
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
