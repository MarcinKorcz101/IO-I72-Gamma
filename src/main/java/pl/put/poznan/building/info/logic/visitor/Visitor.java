package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

public interface Visitor {
    void visitBuilding(Building building);
    void visitLevel(Level level);
    void visitRoom(Room room);
}
