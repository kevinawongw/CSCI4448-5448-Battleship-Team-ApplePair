package edu.colorado.applepear.classes;

import java.util.ArrayList;

public interface Ship {

    String getShipName();
    int getShipHealth();

    void setShipName();
    void setShipHealth();
    void setCaptainsQuarters();

    Boolean isShipSunken();
    void updateHealth(Point location);

}
