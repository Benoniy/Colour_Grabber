
public class grabberColour {
    int red, green, blue;
    String hex;

    public grabberColour(int pixel){
        red = (pixel >> 16) & 0xff;
        green = (pixel >> 8) & 0xff;
        blue = (pixel) & 0xff;
        hex = convertToHex(red, green, blue);

        System.out.println("R: " + red + ", G: " + green + ", B: " + blue + ", " + hex);
    }

    String convertToHex(int red, int green, int blue){
        StringBuilder out = new StringBuilder("#");
        int[] color = {red, green, blue};

        for (int c: color){
            int opperation = c/16;
            for (int i = 0; i < 2; i++){
                if (opperation == 10) {
                    out.append("A");
                }
                else if (opperation == 11) {
                    out.append("B");
                }
                else if (opperation == 12) {
                    out.append("C");
                }
                else if (opperation == 13) {
                    out.append("D");
                }
                else if (opperation == 14) {
                    out.append("E");
                }
                else if (opperation == 15) {
                    out.append("F");
                }
                else{
                    out.append(opperation);
                }
                opperation = c%16;
            }
        }
        return out.toString();
    }
}
