package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Location;
import pl.put.poznan.building.info.logic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Building extends Location {
    private List<Level> levels;

    /**
     * The Building constructor
     * @param id the Integer value of building's id
     * @param name the String to be set as building's name
     */
    public Building(Integer id, String name) {
        super(id, name);
        this.levels = new ArrayList<Level>();
    }

    /**
     *
     * @return a list of levels in building
     */
    public List<Level> getLevels() {
        return levels;
    }

    /**
     *
     * @param levels a list of levels to be set
     */
    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    /**
     *
     * @param level a level to be added to list of levels
     */
    public void addLevel(Level level){
        levels.add(level);
    }

    /**
     *
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitBuilding(this);
    }

}
