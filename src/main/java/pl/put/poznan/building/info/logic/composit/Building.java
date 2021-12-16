package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Location;
import pl.put.poznan.building.info.logic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Building extends Location {
    private List<Level> levels;

    public Building(Integer id, String name) {
        super(id, name);
        this.levels = new ArrayList<Level>();
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    private void addLevel(Level level){
        levels.add(level);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visitBuilding(this);
    }

}
