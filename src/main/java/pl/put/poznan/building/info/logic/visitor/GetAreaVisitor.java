package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

public class GetAreaVisitor implements Visitor{
    @Override
    public double visitBuilding(Building building) {
        return 0;
    }

    @Override
    public double visitLevel(Level level) {
        return 0;
    }

    @Override
    public double visitRoom(Room room) {
        return 0;
    }
}
