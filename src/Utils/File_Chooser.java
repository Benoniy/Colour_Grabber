package Utils;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class File_Chooser extends JPanel {
    private JFileChooser fc;
    private static File returnFile;
    private static File cDir = null;

    public File_Chooser(String mode) {
        super(new BorderLayout());

        //Create a file chooser

        fc = new JFileChooser();

        if (mode.equals("s") | mode.equals("l")){
            FileNameExtensionFilter filter = new FileNameExtensionFilter("configuration files (.cfg)", "cfg", "config");
            fc.setFileFilter(filter);
        }

        if (cDir != null){
            fc.setCurrentDirectory(cDir);
        }

        int returnVal = fc.showOpenDialog(File_Chooser.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            returnFile = fc.getSelectedFile();

            cDir = new File(String.valueOf(returnFile.getParent()));

            System.out.println(returnFile);
        }
        else {
            returnFile = null;
        }

    }

    public static File getFile() {
        return returnFile;
    }

    public static String getFileStr(){
        return returnFile.toString();
    }
}
