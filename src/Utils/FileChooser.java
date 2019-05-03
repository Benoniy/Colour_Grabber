package Utils;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JPanel {
    private JFileChooser fc;
    private static File returnFile;
    private static File cDir = null;

    public FileChooser() {
        super(new BorderLayout());

        //Create a file chooser

        fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
        fc.setFileFilter(filter);

        if (cDir != null){
            fc.setCurrentDirectory(cDir);
        }

        int returnVal = fc.showOpenDialog(FileChooser.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            returnFile = fc.getSelectedFile();
            returnFile = checkFileExtention(returnFile);

            cDir = new File(String.valueOf(returnFile.getParent()));

            System.out.println(returnFile);
        }
        else {
            returnFile = null;
        }

    }

    public static File checkFileExtention(File in) {
        if (!in.toPath().toString().contains(".txt")) {
            in = new File(in.getPath() + ".txt");
        }

        return in;
    }

    public static File getFile() {


        return returnFile;
    }
}
