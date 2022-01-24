package pl.put.poznan.building.info.logic.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetExceededHeatingVisitorTest {

    private GetExceededHeatingVisitor testedVisitor;

    @BeforeEach
    public void setUp(){
        testedVisitor = new GetExceededHeatingVisitor(11,20);
    }


    @Test
    void getCube(){
        assertEquals(0,testedVisitor.getExceededHeating().size());
    }


    @Test
    void visitBuilding() {
        Level level1 = new Level(111, "level1");
        Room room1 = new Room(1,"room1");
        room1.setCube(100);
        room1.setHeating(2000);
        Room room2 = new Room(2,"room2");
        room2.setCube(200);
        room2.setHeating(3000);
        level1.addRoom(room1);
        level1.addRoom(room2);

        Level level2 = new Level(211, "level2");
        Room room3 = new Room(3,"room3");
        room3.setCube(300);
        room3.setHeating(7000);
        Room room4 = new Room(4,"room4");
        room4.setCube(4000);
        room4.setHeating(0);
        level2.addRoom(room3);
        level2.addRoom(room4);

        Building mockBuilding = mock(Building.class);
        when(mockBuilding.getId()).thenReturn(11);
        ArrayList<Level> tmp = new ArrayList<>();
        tmp.add(level1);
        tmp.add(level2);
        when(mockBuilding.getLevels()).thenReturn(tmp);


        testedVisitor.visitBuilding(mockBuilding);
        assertEquals(1,testedVisitor.getExceededHeating().size());
        assertEquals(room3.getId(),testedVisitor.getExceededHeating().get(0));
    }

    @Test
    void visitLevel() {
        Room room1 = new Room(1,"room1");
        room1.setCube(100);
        room1.setHeating(3000);
        Room room2 = new Room(2,"room2");
        room2.setCube(200);
        room2.setHeating(3000);

        Level mockLevel = mock(Level.class);
        when(mockLevel.getId()).thenReturn(11);
        ArrayList<Room> tmp = new ArrayList<>();
        tmp.add(room1);
        tmp.add(room2);
        when(mockLevel.getRooms()).thenReturn(tmp);

        testedVisitor.visitLevel(mockLevel, false);
        assertEquals(1,testedVisitor.getExceededHeating().size());
        assertEquals(room1.getId(),testedVisitor.getExceededHeating().get(0));
    }

    @Test
    void visitRoom() {
        Room mockRoom = mock(Room.class);
        when(mockRoom.getCube()).thenReturn(100.0);
        when(mockRoom.getHeating()).thenReturn(3000.0);
        when(mockRoom.getId()).thenReturn(1);

        testedVisitor.visitRoom(mockRoom,true);
        assertEquals(1, testedVisitor.getExceededHeating().size());
        assertEquals(mockRoom.getId(), testedVisitor.getExceededHeating().get(0));

    }
}