package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

public class GetAreaVisitor implements Visitor{
    private double area = 0;

    public double getArea(){
        return area;
    }

    @Override
    public double visitBuilding(Building building) {
        area = 0;
        return 0;
    }

    @Override
    public double visitLevel(Level level) {
        area = 0;
        return 0;
    }

    @Override
    public double visitRoom(Room room) {
        area = room.getArea();
        return 0;
    }
}
