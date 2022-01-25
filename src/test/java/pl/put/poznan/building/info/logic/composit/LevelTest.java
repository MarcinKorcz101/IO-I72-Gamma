package pl.put.poznan.building.info.logic.composit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    private static Level testedLevel;
    private static Room room1;
    private static Room room2;

    @BeforeEach
    public void setUp(){
        testedLevel = new Level(1234, "testedLevel");
        room1 = new Room(11, "room1");
        room1.setArea(100);
        room1.setCube(1000);
        room1.setHeating(2500);
        room1.setLight(20000);

        room2 = new Room(12, "room2");
        room2.setArea(200);
        room2.setCube(2000);
        room2.setHeating(5000);
        room2.setLight(40000);

        testedLevel.addRoom(room1);
        testedLevel.addRoom(room2);
    }



    @Test
    void getRooms() {
        assertEquals(testedLevel.getRooms().size(),2);
        assertEquals(testedLevel.getRooms().get(0),room1);
        assertEquals(testedLevel.getRooms().get(1),room2);
    }


    @Test
    void addRoom() {
        Room room3 = new Room(13,"tmpRoom");
        testedLevel.addRoom(room3);
        assertEquals(testedLevel.getRooms().size(),3);
        assertEquals(testedLevel.getRooms().get(2),room3);
    }

}