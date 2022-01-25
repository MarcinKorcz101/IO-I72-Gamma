package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class for heating calculations
 */
public class GetHeatingVisitor implements Visitor {
    private int id;
    private double heatingSum;
    private double cubeSum;

    /**
     * The GetHeatingVisitor class constructor
     * @param id the Integer value of location's id
     */
    public GetHeatingVisitor(int id){
        this.id = id;
        this.heatingSum = 0;
        this.cubeSum = 0;
    }
    /**
     * @return calculated heating to cube ratio.
     */
    public double getHeating(){
        BigDecimal bd = new BigDecimal(heatingSum/cubeSum).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
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
     * the method adds the room's cube volume to this class cubeSum and room's Heating value to heatingSum
     * @param room a room of type Room
     * @param isSearchedRoom a boolean if the room is searched
     */
    @Override
    public void visitRoom(Room room, boolean isSearchedRoom) {
        if(room.getId() == id || isSearchedRoom){
            if(room.getCube() != 0 )
                heatingSum += room.getHeating();
            cubeSum += room.getCube();
        }
    }
}
