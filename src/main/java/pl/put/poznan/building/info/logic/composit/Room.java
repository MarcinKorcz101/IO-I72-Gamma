package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.composit.Location;
import pl.put.poznan.building.info.logic.visitor.Visitor;
/**
 * A Room class to represent rooms in a building on a given level,
 *  inherits from the Location class
 */
public class Room extends Location {
    private double area;
    private double cube;
    private double heating;
    private double light;

    /**
     * class Room constructor
     * @param id the room's id
     * @param name the room's name
     */
    public Room(Integer id, String name) {
        super(id, name);
    }

    /**
     *
     * @return Room's area
     */
    public double getArea() {
        return area;
    }

    /**
     *
     * @param area Value of type double of area Room's area to be set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     *
     * @return Room's volume
     */
    public double getCube() {
        return cube;
    }

    /**
     *
     * @param cube Room's volume to be set
     */
    public void setCube(double cube) {
        this.cube = cube;
    }

    /**
     *
     * @return Room's heating
     */
    public double getHeating() {
        return heating;
    }

    /**
     *
     * @param heating Value of type double of Room's heating to be set
     */
    public void setHeating(double heating) {
        this.heating = heating;
    }

    /**
     *
     * @return Room's light power
     */
    public double getLight() {
        return light;
    }

    /**
     *
     * @param light Value of type double of Room's light power to be set
     */
    public void setLight(double light) {
        this.light = light;
    }

    /**
     *  Concrete method that enables Visitor to use this class methods
     * @param visitor - the visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitRoom(this, false);
    }
}
