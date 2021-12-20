package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

/**
 * Interface of a Visitor to visit locations such as: Building, Level, Room
 */
public interface Visitor {
    /**
     *
     * @param building a building of type Building
     */
    void visitBuilding(Building building);

    /**
     *
     * @param level a level of type Level
     * @param isSearchedLevel a boolean if the level is searched
     */
    void visitLevel(Level level, boolean isSearchedLevel);

    /**
     *
     * @param room a room of type Room
     * @param isSearchedRoom a boolean if the room is searched
     */
    void visitRoom(Room room, boolean isSearchedRoom);
}
