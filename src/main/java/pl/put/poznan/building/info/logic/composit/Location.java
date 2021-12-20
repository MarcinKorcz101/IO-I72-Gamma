package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.visitor.Visitor;

/**
 * Abstract class for representing objects such as: Level, Room, Building
 */
public abstract class Location {
    private Integer id;
    private String name;

    public Location(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return location's id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id location's id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return location's name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name location's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Abstract method
     * @param visitor
     */
    abstract void accept(Visitor visitor);
}
