import GUI.MyLabel;
import Utils.grabberColour;

import javax.swing.*;
import java.awt.*;

public class colourElement extends JPanel {

    public colourElement(grabberColour c, MyFrame frame) {
        super();

        setLayout( new GridBagLayout());
        setPreferredSize(new Dimension(400, 90));

        GridBagConstraints gbc = new GridBagConstraints();

        //Outer Encapsulation
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JPanel IMG = new JPanel();
        IMG.setMinimumSize(new Dimension(90, 90));
        IMG.setPreferredSize(new Dimension(90, 90));
        IMG.setBackground(c.rgb);
        IMG.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.add(IMG, gbc);

        gbc.gridx = 1;
        JPanel content = new JPanel(new GridBagLayout());
        content.setMinimumSize(new Dimension(310, 90));
        content.setPreferredSize(new Dimension(310, 90));
        content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.add(content, gbc);

        //Inner Encapsulation
        MyLabel red = new MyLabel("Red:"), green = new MyLabel("Green:"), blue = new MyLabel("Blue:"),
                hex = new MyLabel("Hex:");

        MyLabel redCon = new MyLabel(String.valueOf(c.red)), greenCon = new MyLabel(String.valueOf(c.green)),
                blueCon = new MyLabel(String.valueOf(c.blue)), hexCon = new MyLabel(String.valueOf(c.hex));

        gbc.ipadx = 15;
        gbc.gridx = 0;
        content.add(red,gbc);
        gbc.gridy = 1;
        content.add(redCon, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        content.add(green,gbc);
        gbc.gridy = 1;
        content.add(greenCon, gbc);

        gbc.gridy = 0;
        gbc.gridx = 2;
        content.add(blue,gbc);
        gbc.gridy = 1;
        content.add(blueCon, gbc);

        gbc.gridy = 0;
        gbc.gridx = 3;
        content.add(hex,gbc);
        gbc.gridy = 1;
        content.add(hexCon, gbc);

        //Delete button
        JButton delButton = new JButton("Delete");

        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        content.add(delButton, gbc);

        delButton.addActionListener(e -> {
            Constants.colours.remove(c);

            int size = frame.colourPanel.getSize().height;
            if (size > 542){
                if (Constants.colours.size() > 6){
                    frame.colourPanel.setPreferredSize(new Dimension(400, size - 90));
                }
                else {
                    frame.colourPanel.setPreferredSize(new Dimension(400, 540));
                    frame.scroll.setPreferredSize(new Dimension(402, 542));
                }
            }

            frame.genColourPanel();
        });
    }
}
