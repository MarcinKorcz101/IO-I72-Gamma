package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

public class GetHeatingVisitor implements Visitor {
    private double heating;

    public double getHeating(){
        return heating;
    }
    @Override
    public void visitBuilding(Building building) {
        heating = 0;
    }

    @Override
    public void visitLevel(Level level) {
        heating = 0;
    }

    @Override
    public void visitRoom(Room room) {
        heating = 0;
    }
}
