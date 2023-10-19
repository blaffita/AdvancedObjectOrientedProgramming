package noapplet.DrawingBoardApp;

import java.awt.*;

public class Triangle extends Shape{
    int[] x;
    int[] y;
    protected Triangle(int[] x, int[] y, Color c) {
        super(0, 0 , Color.BLACK);
        this.x = x;
        this.y = y;

    }
    public void draw(Graphics g) {
        g.drawPolygon(x, y, 3);
    }
}
