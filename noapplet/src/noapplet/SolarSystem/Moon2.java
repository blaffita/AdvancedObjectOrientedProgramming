package noapplet.SolarSystem;
import java.awt.*;

public class Moon2 extends solarSystem{
    int distanceFromPlanet2;
    Planet2 planet2;

    public Moon2(Planet2 planet, int distanceFromPlanet, int diameter) {
        super(400, 300, diameter, Color.GRAY);
        this.planet2 = planet;
        this.distanceFromPlanet2 = distanceFromPlanet;
    }

    public void updatePosition(double angle) {
        x = planet2.x + (int)(distanceFromPlanet2 * Math.cos(angle));
        y = planet2.y + (int)(distanceFromPlanet2 * Math.sin(angle));
    }
}
