package pl.put.poznan.building.info.data;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

public class BuildingData {
    public static Building get(){
        Room kitchen = new Room(0,"Kitchen");
        kitchen.setArea(10);
        Room bedroom = new Room(1,"Bedroom");
        bedroom.setArea(14);
        Room bathroom = new Room(2,"Bathroom");
        bathroom.setArea(7);

        Level level = new Level(10, "Floor");
        level.addRoom(kitchen);
        level.addRoom(bedroom);
        level.addRoom(bathroom);

        Building building = new Building(20, "House");
        building.addLevel(level);

        return building;
    }
}
