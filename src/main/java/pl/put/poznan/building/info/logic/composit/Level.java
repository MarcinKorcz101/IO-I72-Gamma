package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Level extends Location {
    private List<Room> rooms;

    public Level(Integer id, String name) {
        super(id, name);
        this.rooms = new ArrayList<Room>();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visitLevel(this);
    }
}
