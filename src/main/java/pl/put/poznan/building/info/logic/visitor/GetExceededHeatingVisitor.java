package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class GetExceededHeatingVisitor implements Visitor{
    private final int id;
    private final double threshold;
    private ArrayList<Integer> ExceededIds;

    public GetExceededHeatingVisitor(int id, double threshold){
        this.id = id;
        this.threshold = threshold;
        this.ExceededIds = new ArrayList<>();
    }

    public ArrayList<Integer> getExceededHeating(){
        return ExceededIds;
    }

    @Override
    public void visitBuilding(Building building) {
        boolean isSearchedBuilding = building.getId() == id;
        for ( Level level : building.getLevels()){
            visitLevel(level, isSearchedBuilding);
        }
    }

    @Override
    public void visitLevel(Level level, boolean isSearchedLevel) {
        for ( Room room : level.getRooms()){
            visitRoom(room, isSearchedLevel);
        }
    }

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
