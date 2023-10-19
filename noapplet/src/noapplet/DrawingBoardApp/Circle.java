package noapplet.DrawingBoardApp;

import java.awt.*;

public class Circle extends Shape{

    protected Circle(int x, int y, Color c) {
        super(x, y, c);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(getX(), getY(), 70, 70);
        g.setColor(Color.RED);
    }
}
