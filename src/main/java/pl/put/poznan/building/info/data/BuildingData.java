package pl.put.poznan.building.info.data;

import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

public class BuildingData {
    public static Building get(){
        Room kitchen = new Room(0,"Kitchen");
        kitchen.setArea(10);
        Room bedroom1 = new Room(1,"Bedroom");
        bedroom1.setArea(14);
        Room bathroom1 = new Room(2,"Bathroom");
        bathroom1.setArea(7);
        Room bedroom2 = new Room(3,"Bedroom");
        bedroom2.setArea(17);
        Room bathroom2 = new Room(4,"Bathroom");
        bathroom2.setArea(4);

        Level level1 = new Level(10, "Floor 1");
        level1.addRoom(kitchen);
        level1.addRoom(bedroom1);
        level1.addRoom(bathroom1);

        Level level2 = new Level(11, "Floor 2");
        level2.addRoom(bedroom2);
        level2.addRoom(bathroom2);






        Building building = new Building(20, "House");
        building.addLevel(level1);
        building.addLevel(level2);

        return building;
    }
}