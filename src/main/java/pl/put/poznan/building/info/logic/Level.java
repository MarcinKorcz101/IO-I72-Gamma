package pl.put.poznan.building.info.logic;

import java.util.List;

public class Level extends Location{
    private List<Room> rooms;

    public Level(Integer id, String name) {
        super(id, name);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    private void addRoom(Room room){
        rooms.add(room);
    }
}
