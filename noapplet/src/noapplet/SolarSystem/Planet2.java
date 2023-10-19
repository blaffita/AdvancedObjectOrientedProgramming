package noapplet.SolarSystem;
import java.awt.*;

public class Planet2 extends solarSystem{

    int distanceFromSun;

    public Planet2(int distanceFromSun){
        super(600, 600, 35, Color.GREEN);
        this.distanceFromSun = distanceFromSun;
    }
    public void updatePosition(double angle) {
        x = 450 + (int)(distanceFromSun * Math.cos(angle));
        y = 450 + (int)(distanceFromSun * Math.sin(angle));
    }
}
