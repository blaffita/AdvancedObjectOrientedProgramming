package noapplet.SolarSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class solarSystemAnimation extends JPanel {
    Sun sun;
    Planet planet;
    Planet2 planet2;
    Moon moon;
    Moon2 moon2;
    double angle = 0.0;
    double angle2 = 0.0;

    public solarSystemAnimation() {
        setPreferredSize(new Dimension(1000, 9010));
        sun = new Sun(450, 400, 100, Color.YELLOW);
        planet = new Planet(230);
        planet2 = new Planet2(400);
        setBackground(Color.BLACK);
        moon = new Moon(planet, 60, 15);
        moon2 = new Moon2(planet2, 50, 15);

        int delay = 30;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                angle += 0.02;
                planet.updatePosition(angle);
                angle2 += 0.008;
                planet2.updatePosition(angle2);
                moon.updatePosition(angle * 3);
                moon2.updatePosition(angle2 * 10);
                repaint();
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Benjamin Laffita", 10, 10);
        g.setColor(Color.WHITE);
        sun.draw(g);
        planet.draw(g);
        planet2.draw(g);
        moon.draw(g);
        moon2.draw(g);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new solarSystemAnimation());
        frame.pack();
        frame.setVisible(true);
    }
}













