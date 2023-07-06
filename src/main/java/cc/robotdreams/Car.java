package cc.robotdreams;

import java.util.ArrayList;
import java.util.List;

public enum Car
{
    // final public static Car MERCEDES_BENZ = new Car("MERCEDES_BENZ");
    MERCEDES_BENZ   (Color.BLACK,   Driver.ANNA),
    BMW             (Color.GREEN,   Driver.ANDRII),
    RENO            (Color.BLUE,    Driver.SERGII),
    HONDA           (Color.GREY,    Driver.ANNA);

    final public Driver       driver;
    final public Color        color;
    final private List<String> passangers = new ArrayList<>();

    Car (Color color, Driver driver) {
        this.color  = color;
        this.driver = driver;
    }



    @Override
    public String toString () {
        return this.name() + " - color: " + color + ", driver: " + driver;
    }

}
