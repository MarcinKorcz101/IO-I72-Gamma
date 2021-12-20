package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * Class for lighting calculations
 */
public class GetLightVisitor implements Visitor{
    private double lightSum;
    private double areaSum;
    private int id;

    public GetLightVisitor(int id) {
        this.id = id;
        this.lightSum = 0;
        this.areaSum = 0;
    }

    public double getLight(){
        BigDecimal bd = new BigDecimal(lightSum/areaSum).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
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

    @Override
    public void visitLevel(Level level, boolean isSearchedLevel) {
        if (level.getId() == id) {
            isSearchedLevel = true;
        }
        for ( Room room : level.getRooms()){
            visitRoom(room, isSearchedLevel);
        }
    }

    @Override
    public void visitRoom(Room room, boolean isSearchedRoom) {
        if(room.getId() == id || isSearchedRoom){
            if(room.getArea() != 0 )
            lightSum += room.getLight();
            areaSum += room.getArea();
        }
    }
}
