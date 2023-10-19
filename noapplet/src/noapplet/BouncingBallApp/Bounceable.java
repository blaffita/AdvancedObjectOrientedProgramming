package noapplet.BouncingBallApp;

import java.awt.*;

interface Bounceable {
    void move();
    void draw(Graphics g);
    boolean isColliding(Ball other);
    void onCollision();
    int getX();
    int getY();
    int getSize();
    int getHeight();
    int getWidth();
}
