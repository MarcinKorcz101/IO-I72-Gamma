package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


/**
 * Class for exceeded heating calculations
 */
public class GetExceededHeatingVisitor implements Visitor{
    /**
     * id of type int for storing location's id to visit
     */
    private final int id;
    /**
     * threshold of type double for exceeded heating calculations
     */
    private final double threshold;
    /**
     * list of type int for storing ids for loactions that exceeded heating
     */
    private ArrayList<Integer> ExceededIds;

    /**
     * The GetExceededHeatingVisitor class constructor
     * @param id the Integer value of location's id
     * @param threshold the double value of threshold provided by the user
     */
    public GetExceededHeatingVisitor(int id, double threshold){
        this.id = id;
        this.threshold = threshold;
        this.ExceededIds = new ArrayList<>();
    }
    /**
     * @return List of locations that exceeded threshold.
     */
    public ArrayList<Integer> getExceededHeating(){
        return ExceededIds;
    }
    /**
     * Visits a building given as a parameter
     * and then visits every level in this building
     * @param building a building of type Building
     */
    @Override
    public void visitBuilding(Building building) {
        boolean isSearchedBuilding = building.getId() == id;
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
        for ( Room room : level.getRooms()){
            visitRoom(room, isSearchedLevel);
        }
    }

    /**
     * If room heating exceeds the threshold value
     * the method adds the room id
     * to the list of exceeded rooms
     * @param room a room of type Room
     * @param isSearchedRoom a boolean if the room is searched
     */
    @Override
    public void visitRoom(Room room, boolean isSearchedRoom) {
        if (room.getCube() != 0){
            BigDecimal bd = new BigDecimal(room.getHeating()/room.getCube()).setScale(2, RoundingMode.HALF_UP);
            if (bd.doubleValue() > threshold){
                ExceededIds.add(room.getId());
            }
        }
    }
}
