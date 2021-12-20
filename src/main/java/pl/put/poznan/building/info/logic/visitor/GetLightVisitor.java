package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;


public class GetLightVisitor implements Visitor{
    private double light;
    private int id;

    public GetLightVisitor(int id) {
        this.id = id;
        this.light = 0;
    }

    public double getLight(){
        return light;
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
            light += room.getLight()/room.getArea();
        }
    }
}
