package Utils;

import java.awt.*;

public class Colour_Object {
    public int red, green, blue;
    public String hex;
    public Color rgb;

    public Colour_Object(int pixel){
        red = (pixel >> 16) & 0xff;
        green = (pixel >> 8) & 0xff;
        blue = (pixel) & 0xff;
        rgb = new Color(red, green, blue);
        hex = convertToHex(red, green, blue);
        System.out.println(this.toString());
    }

    public Colour_Object(Color color){
        rgb = color;
        red = rgb.getRed();
        green = rgb.getGreen();
        blue = rgb.getBlue();
        hex = convertToHex(red, green, blue);
        System.out.println(this.toString());
    }

    private String convertToHex(int red, int green, int blue){
        StringBuilder out = new StringBuilder("#");
        int[] color = {red, green, blue};

        for (int c: color){
            int operation = c/16;
            for (int i = 0; i < 2; i++){
                if (operation == 10) {
                    out.append("A");
                }
                else if (operation == 11) {
                    out.append("B");
                }
                else if (operation == 12) {
                    out.append("C");
                }
                else if (operation == 13) {
                    out.append("D");
                }
                else if (operation == 14) {
                    out.append("E");
                }
                else if (operation == 15) {
                    out.append("F");
                }
                else{
                    out.append(operation);
                }
                operation = c%16;
            }
        }
        return out.toString();
    }

    public String toString(){
        return "R: " + red + ", G: " + green + ", B: " + blue + ", Hex: " + hex;
    }
}
