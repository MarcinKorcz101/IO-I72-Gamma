package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

public class GetCubeVisitor implements Visitor{
    private double cube;

    public double getCube(){
        return cube;
    }

    @Override
    public void visitBuilding(Building building) {
        cube = 0;
    }

    @Override
    public void visitLevel(Level level) {
        cube = 0;
    }

    @Override
    public void visitRoom(Room room) {
        cube = 0;
    }
}
