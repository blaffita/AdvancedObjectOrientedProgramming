package noapplet.SolarSystem;

import java.awt.*;

abstract class solarSystem{
    int x, y, diameter;
    Color color;

    public solarSystem(int x, int y, int diameter, Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}


