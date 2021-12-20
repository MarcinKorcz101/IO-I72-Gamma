package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

/**
 * Interface of a Visitor to visit locations
 */

public interface Visitor {
    void visitBuilding(Building building);
    void visitLevel(Level level, boolean isSearchedLevel);
    void visitRoom(Room room, boolean isSearchedRoom);
}
