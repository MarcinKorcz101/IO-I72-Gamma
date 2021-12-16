package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

public interface Visitor {
    double visitBuilding(Building building);
    double visitLevel(Level level);
    double visitRoom(Room room);
}
