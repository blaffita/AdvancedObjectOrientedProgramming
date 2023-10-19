package noapplet.BouncingBallApp;

import java.awt.*;

public abstract class Ball implements Bounceable {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private final int radius;
    private final Color c;
    private final int width;
    private final int height;


    protected Ball(int x, int y, int dx, int dy, int radius, Color c, int width, int height){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.c = c;
        this.width = width;
        this.height = height;
    }
    public void move(){
        if(x < radius || x > width - radius){
            dx = -dx;
        }
        if(y < radius || y > height - radius){
            dy = -dy;
        }
        x+= dx;
        y += dy;
    }
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    @Override
    public boolean isColliding(Ball other) {
        int distance = (int) Math.sqrt(Math.pow(x - other.getX(), 2) + Math.pow(y - other.getY(), 2));
        return distance < (radius + other.getSize());
    }
    @Override
    public void onCollision() {
        dx = -dx;
        dy = -dy;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }
    @Override
    public int getSize() {
        return radius;
    }
    @Override
    public int getHeight(){
        return 2 * radius;
    }
    @Override
    public int getWidth(){
        return 2 * radius;
    }
}

