package noapplet.example;

import noapplet.NoApplet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Simple NoAppet app to draw a text and an image. The displayed image
 * is obtained from the file <code>res/rabbit.jpg</code>, where
 * <code>res</code> is the resource directory of your Java project.
 * Refer to your IDE to designate the resource directory for your project.
 */
@SuppressWarnings("serial")
public class HelloWorld extends NoApplet {

	public HelloWorld() {
	}

	public HelloWorld(String[] params) {
		super(params);
	}
	
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.BLACK);
        g.drawString("Benjamin Laffita", 75, 58);
        for (int i = 0; i <20; i++) {
            for (int j = 0; j < 20; j++) {
                g.drawRect(i*20, j*20, 20, 20);
            }
        }
        g.fillOval(173,172,15, 15);
        g.drawOval(173, 172, 15, 15);
        g.setColor(Color.WHITE);
        g.fillOval(152, 153, 15, 15);
        g.setColor(Color.BLACK);
        g.drawOval(152, 153, 15, 15);
        g.setColor(Color.BLACK);
    }

    public static void main(String[] args) {
    	//new HelloWorld().run();
    	// or specify optional parameters such as the window size
        new HelloWorld(new String[] {"width=360", "height=360"}).run();
    }
}
