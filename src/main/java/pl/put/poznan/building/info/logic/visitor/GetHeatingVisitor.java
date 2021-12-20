package pl.put.poznan.building.info.logic.visitor;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

/**
 * Class for heating calculations
 */
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
    public void visitLevel(Level level, boolean isSearchedLevel) {
        heating = 0;
    }

    @Override
    public void visitRoom(Room room, boolean isSearchedRoom) {
        heating = 0;
    }
}
