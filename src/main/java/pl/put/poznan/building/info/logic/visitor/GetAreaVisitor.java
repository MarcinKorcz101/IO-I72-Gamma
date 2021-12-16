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
    public void visitBuilding(Building building) {
        area = 0;
    }

    @Override
    public void visitLevel(Level level) {
        area = 0;
    }

    @Override
    public void visitRoom(Room room) {
        area = room.getArea();
    }
}
