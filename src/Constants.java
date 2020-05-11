import Utils.FileChooser;
import Utils.grabberColour;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Constants {
    public static ArrayList<grabberColour> colours = new ArrayList<>();


    public static void load(MyFrame fr){

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            new FileChooser("l");
            File dir = FileChooser.getFile();

            try{
                BufferedReader rd = new BufferedReader(new FileReader(dir));
                String str = rd.readLine();
                rd.close();

                str = str.replace(String.valueOf((char)91) , "");
                str = str.replace(String.valueOf((char)93) , "");

                String[] list = str.split(",");

                int count = 0, r = 0, g = 0, b = 0;
                int calc = 3;

                colours.clear();
                for(String s : list){
                    if (count == 0){
                        r = Integer.parseInt(s.substring(calc, s.length()));
                    }
                    else if (count == 1){
                        g = Integer.parseInt(s.substring(calc, s.length()));
                    }
                    else if (count == 2){
                        b = Integer.parseInt(s.substring(calc, s.length()));
                    }
                    else if (count == 3){
                        colours.add(new grabberColour(new Color(r, g, b)));
                        count = -1;
                    }
                    calc = 4;
                    count++;
                }

            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            fr.genColourPanel();
            fr.pack();
        });
    }

    public static void save(MyFrame fr) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            new FileChooser("s");
            String dir = FileChooser.getFileStr();
            if (!dir.toLowerCase().contains(".cfg")){
                dir += ".cfg";
            }

            File file = new File(dir);

            try{
                file.delete();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(String.valueOf(colours));
                fileWriter.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            fr.genColourPanel();
        });
    }
}
