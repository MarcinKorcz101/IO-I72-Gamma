package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;


public class Level extends Location {
    private List<Room> rooms;

    /**
     * Level constructor
     * @param id the Integer value of level's id
     * @param name the String to be set as level's name
     */
    public Level(Integer id, String name) {
        super(id, name);
        this.rooms = new ArrayList<Room>();
    }

    /**
     *
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
     * @param room the room to be added
     */
    public void addRoom(Room room){
        rooms.add(room);
    }

    /**
     *
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitLevel(this, false);
    }
}
