package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

public class GetLightVisitor implements Visitor{
    private double light;

    public double getLight(){
        return light;
    }
    @Override
    public void visitBuilding(Building building) {
        light = 0;
    }

    @Override
    public void visitLevel(Level level, boolean isSearchedLevel) {
        light = 0;
    }

    @Override
    public void visitRoom(Room room, boolean isSearchedRoom) {
        light = 0;
    }
}
