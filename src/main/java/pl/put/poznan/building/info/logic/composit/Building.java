package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Location;
import pl.put.poznan.building.info.logic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * A Building class to represent building,
 * inherits from the Location class,
 * consists of levels of type Level
 */
public class Building extends Location {
    /**
     *  A list of levels of type Level
     */
    private List<Level> levels;

    /**
     * The Building class constructor
     * @param id the Integer value of location's id
     * @param name the String to be set as location's name
     */
    public Building(Integer id, String name) {
        super(id, name);
        this.levels = new ArrayList<Level>();
    }

    /**
     *
     * @return a list of levels in a building
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
     * Concrete method that enables Visitor to use this class methods
     * @param visitor a visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitBuilding(this);
    }

}
