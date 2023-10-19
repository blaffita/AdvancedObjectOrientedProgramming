package noapplet.DrawingBoardApp;

import java.awt.*;

public class Rectangle extends Shape{

    protected Rectangle(int x, int y, Color c) {
        super(x, y, c);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(getX(), getY(), 100, 70);
        g.setColor(Color.BLUE);
    }
}
