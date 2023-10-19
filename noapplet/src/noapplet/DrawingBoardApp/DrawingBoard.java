package noapplet.DrawingBoardApp;

import noapplet.NoApplet;

import java.awt.*;

public class DrawingBoard extends NoApplet {
    Circle circle;
    Rectangle rec;
    Triangle triangle;


    public DrawingBoard(String[] params) {
        super(params);
    }

    @Override
    public void init() {
        circle = new Circle(100, 100, Color.RED);
        rec = new Rectangle(200, 200, Color.GREEN);
        triangle = new Triangle(new int[]{400, 250, 550}, new int[]{270, 530, 530}, Color.BLACK);
    }

    protected void paintComponent(Graphics g){
        circle.draw(g);
        rec.draw(g);
        triangle.draw(g);
        g.fillPolygon(new int[]{400, 250, 550}, new int[]{270, 530, 530}, 3);
        g.setColor(Color.BLACK);
        g.drawString("Benjamin Laffita", 350, 100);
    }
    public static void main(String[] args){
        new DrawingBoard(new String[] {"width = 700", "height = 700"}).run();
    }
}
