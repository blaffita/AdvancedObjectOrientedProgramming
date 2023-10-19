package noapplet.DrawingBoardApp;

import java.awt.*;

public abstract class Shape{

    private final int x;
    private final int y;
    private final Color c;

    protected Shape(int x, int y, Color c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
    public abstract void draw(Graphics g);

        public int getX() {
            return x;
    }

        public int getY() {
            return y;
    }

    public Color getColor() {
            return c;
    }
}
