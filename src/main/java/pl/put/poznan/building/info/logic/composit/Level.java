package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * A Level class to represent levels in a building,
 *  inherits from the Location class,
 *  consists of rooms of type Room
 */
public class Level extends Location {
    /**
     *  A list of rooms of type Room
     */
    private List<Room> rooms;

    /**
     * The Level class constructor
     * @param id the Integer value of location's id
     * @param name the String to be set as location's name
     */
    public Level(Integer id, String name) {
        super(id, name);
        this.rooms = new ArrayList<Room>();
    }

    /**
     * @return the list of rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     *
     * @param rooms a list of rooms to be set
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Method adds a room to the list of rooms
     * @param room a room to be added
     */
    public void addRoom(Room room){
        rooms.add(room);
    }

    /**
     * Concrete method that enables Visitor to use this class methods
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitLevel(this, false);
    }
}
