import Utils.Colour_Object;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {
    JScrollPane scroll;
    JPanel colourPanel = new JPanel(new GridLayout(6, 1));

    MyFrame(String title){
        super(title);
        genDefaultLayout();
    }

    //Regular functioning window
    private void genDefaultLayout(){
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);

        toFront();

        setMinimumSize(new Dimension(400, 590));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            this.setIconImage(ImageIO.read(MyFrame.class.getResource("icon.png")));
        } catch (Exception e) {
            ImageIcon img = new ImageIcon("icon.png");
            this.setIconImage(img.getImage());
        }

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
        JButton newBut = new JButton("New...");
        contentPanel.add(newBut, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JButton newImgBut = new JButton("New From Image...");
        contentPanel.add(newImgBut, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 1;
        JButton saveBut = new JButton("Save");
        contentPanel.add(saveBut, gbc);

        gbc.gridx = 3;
        JButton loadBut = new JButton("Load");
        contentPanel.add(loadBut, gbc);

        //Row 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 9;

        colourPanel.setPreferredSize(new Dimension(400, 540));
        colourPanel.setAutoscrolls(true);

        scroll = new JScrollPane(colourPanel);
        scroll.setPreferredSize(new Dimension(402, 542));


        contentPanel.add(scroll, gbc);

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

        newImgBut.addActionListener(e -> {
            try{
                Main.startIMGCap();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        });

        loadBut.addActionListener(e -> {
            Constants.load(this);
            colourPanel.revalidate();
            colourPanel.repaint();
        });
        saveBut.addActionListener(e -> {
            Constants.save(this);
            colourPanel.revalidate();
            colourPanel.repaint();
        });

        this.pack();
    }

    public void genColourPanel(){
        colourPanel.removeAll();
        if (Constants.colours.size() > 6){
            colourPanel.setLayout(new GridLayout(Constants.colours.size(),1));
            colourPanel.setPreferredSize(new Dimension(400, 540 + ((Constants.colours.size() - 6) * 90)));
            scroll.setPreferredSize(new Dimension(420, 542));
        }
        else {
            colourPanel.setLayout(new GridLayout(6, 1));
        }

        for (Colour_Object c : Constants.colours){
            colourPanel.add(new Colour_Frame(c, this));
        }

        colourPanel.revalidate();
        colourPanel.repaint();
    }
}
