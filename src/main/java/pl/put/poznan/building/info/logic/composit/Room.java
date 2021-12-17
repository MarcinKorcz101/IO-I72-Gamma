package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.composit.Location;
import pl.put.poznan.building.info.logic.visitor.Visitor;

public class Room extends Location {
    private double area;
    private double cube;
    private double heating;
    private double light;

    public Room(Integer id, String name) {
        super(id, name);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCube() {
        return cube;
    }

    public void setCube(double cube) {
        this.cube = cube;
    }

    public double getHeating() {
        return heating;
    }

    public void setHeating(double heating) {
        this.heating = heating;
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRoom(this, false);
    }
}
