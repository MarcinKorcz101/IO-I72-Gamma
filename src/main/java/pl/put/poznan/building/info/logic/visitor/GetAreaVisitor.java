package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

/**
 * Class for calculations of area
 */
public class GetAreaVisitor implements Visitor{
    /**
     * Attributes:
     * area of type double for storing visited rooms area in m^2
     * id - unique id of type id
     */
    private double area;
    private int id;

    /**
     * Class constructor assigning id and setting area to 0
     * @param id  id of type int
     */
    public GetAreaVisitor(int id) {
        this.id = id;
        this.area = 0;
    }

    /**
     * @return room's area of type double
     */
    public double getArea(){
        return area;
    }

    /**
     * Visits a building given as a parameter
     * and then visits every level in this building
     * @param building a building of type Building
     */
    @Override
    public void visitBuilding(Building building) {
        boolean isSearchedBuilding = false;
        if (building.getId() == id) {
            isSearchedBuilding = true;
        }
        for ( Level level : building.getLevels()){
            visitLevel(level, isSearchedBuilding);
        }


    }

    /**
     * Visits a level given as a parameter
     * and then visits every room on that level
     * @param level a level of type Level
     * @param isSearchedLevel a boolean if the level is searched
     */
    @Override
    public void visitLevel(Level level, boolean isSearchedLevel) {
        if (level.getId() == id) {
            isSearchedLevel = true;
        }
        for ( Room room : level.getRooms()){
            visitRoom(room, isSearchedLevel);
        }

    }

    /**
     * if the room's id equals to this class id
     * or if isSearchedRoom parameter is true
     * the method adds the room's area to this class area
     * @param room a room of type Room
     * @param isSearchedRoom a boolean if the room is searched
     */
    @Override
    public void visitRoom(Room room, boolean isSearchedRoom) {

        if(room.getId() == id || isSearchedRoom){
            area += room.getArea();
        }

    }
}
