package noapplet.SolarSystem;

import java.awt.*;

public class Planet extends solarSystem{
    int distanceFromSun;

    public Planet(int distanceFromSun) {
        super(250, 300, 35, Color.BLUE);
        this.distanceFromSun = distanceFromSun;
    }


    public void updatePosition(double angle) {
        x = 450 + (int)(distanceFromSun * Math.cos(angle));
        y = 450 + (int)(distanceFromSun * Math.sin(angle));
    }
}

