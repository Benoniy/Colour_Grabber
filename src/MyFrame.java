import GUI.MyButton;
import GUI.colourElement;
import Utils.Constants;
import Utils.grabberColour;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {
    GridLayout colourPanelLayout = new GridLayout(6, 1);
    JPanel colourPanel = new JPanel(colourPanelLayout);

    public MyFrame(String title){
        super(title);
        genDefaultLayout();
    }

    //Regular functioning window
    public void genDefaultLayout(){
        setBackground(Color.LIGHT_GRAY);
        setUndecorated(false);
        setVisible(true);

        setMinimumSize(new Dimension(400, 590));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Ui look and feel
        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (Exception e){e.printStackTrace();}

        //Contents
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel contentPanel = new JPanel(layout);
        this.add(contentPanel);

        //Row 0
        gbc.gridy = 0;
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        MyButton newBut = new MyButton("New");
        contentPanel.add(newBut, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        MyButton newImgBut = new MyButton("New From Image");
        contentPanel.add(newImgBut, gbc);

        gbc.gridx = 3;
        gbc.gridwidth = 1;
        MyButton saveBut = new MyButton("Save");
        contentPanel.add(saveBut, gbc);

        gbc.gridx = 4;
        MyButton loadBut = new MyButton("Load");
        contentPanel.add(loadBut, gbc);

        //Row 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 9;

        colourPanel.setPreferredSize(new Dimension(400, 540));
        colourPanel.setBackground(Color.BLUE);
        contentPanel.add(colourPanel, gbc);

        genColourPanel();

        //Action listeners
        newBut.addActionListener(e -> {
            try{
                Main.startCap();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        });

        this.pack();
    }

    public void genColourPanel(){
        for (grabberColour c : Constants.colours){
            colourPanel.add(new colourElement(c));
        }
    }
}
