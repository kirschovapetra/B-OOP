package cv6;

import java.awt.*;

//gradient
public class MyCanvas extends Canvas {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();
        int red = 10;
        int green = 121;
        int blue =1;

        while(red<=255 || green<=255 || blue<=255) {
            Color color = new Color(red, blue, green);
            g.setColor(color);
            g.fillRect(x, y, width, height);
            x++;
            y++;
            width-=2;
            height-=2;
            if (red<255){
                red++;
            }
            else if (blue<255){
                blue++;
            }
            else if (green<255){
                green++;
            }
        }
    }
}
