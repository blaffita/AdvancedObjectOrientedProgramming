package noapplet.BouncingBallApp;

import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BouncingBall extends NoApplet{
    private final List<Ball> balls = new ArrayList<>();
    int numOfBalls;

    public BouncingBall(String[] params) {
        super(params);
    }

    public void init() {
        this.setSize(700, 700);
        this.numOfBalls = 5;
        for (int i = 0; i < numOfBalls; i++) {
            balls.add(new CircleBall(
                    (int) (Math.random() * getWidth()),
                    (int) (Math.random() * getHeight()),
                    (int) (Math.random() * 5) - 2,
                    (int) (Math.random() * 5) - 2,
                    (int) (Math.random() * 30) + 10,
                    Color.GREEN, getWidth(), getHeight()
            ));
        }
        Timer timer = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Ball ball : balls) {
            ball.move();
            for (Ball other : balls) {
                if (ball != other && ball.isColliding(other)) {
                    ball.onCollision();
                    other.onCollision();
                }
            }
            ball.draw(g);
        }
    }
    public static void main(String[] args){
        new BouncingBall(new String[] {"width = 700", "height = 700"}).run();

    }
}

