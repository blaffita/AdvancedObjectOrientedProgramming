package noapplet.SolarSystem;

import java.awt.*;

public class Moon extends solarSystem{
    int distanceFromPlanet;
    Planet planet;

    public Moon(Planet planet, int distanceFromPlanet, int diameter) {
        super(400, 300, diameter, Color.GRAY);
        this.planet = planet;
        this.distanceFromPlanet = distanceFromPlanet;
    }

    public void updatePosition(double angle) {
        x = planet.x + (int)(distanceFromPlanet * Math.cos(angle));
        y = planet.y + (int)(distanceFromPlanet * Math.sin(angle));
    }
}

