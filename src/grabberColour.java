
public class grabberColour {
    int red, green, blue;
    String hex;

    public grabberColour(int pixel){
        red = (pixel >> 16) & 0xff;
        green = (pixel >> 8) & 0xff;
        blue = (pixel) & 0xff;
        hex = convertToHex(red, green, blue);

        System.out.println("R: " + red + ", G: " + green + ", B: " + blue);
    }

    String convertToHex(int red, int green, int blue){
        String out = "#";

        return out;
    }
}
