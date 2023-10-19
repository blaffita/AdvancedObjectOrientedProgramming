package noapplet.BouncingBallApp;

import java.awt.*;

public class CircleBall extends Ball {
    protected CircleBall(int x, int y, int dx, int dy, int radius, Color c, int height, int width) {
        super(x, y, dx, dy, radius, c, width, height);
    }
    public void draw(Graphics g) {
        g.drawOval(getX(), getY(), 50, 50);
        g.setColor(Color.GREEN);
        g.fillOval(getX(), getY(), 50, 50);
    }
}
