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

class GetHeatingVisitorTest{
    private GetHeatingVisitor testedVisitor;

    @BeforeEach
    public void setUp(){
        testedVisitor = new GetHeatingVisitor(11);
    }

    /**
     * This test checks if getHeatingVisitor's getHeating() method when no location was visited returns NumberFormatException (dividing by zero)
     */
    @Test
    void getHeatingThrowsExceptionTest(){
        assertThrows(java.lang.NumberFormatException.class,() -> {testedVisitor.getHeating();});
    }

    @Test
    void visitBuildingTest() {
        Level level1 = new Level(111, "level1");
        Room room1 = new Room(1,"room1");
        room1.setCube(20);
        room1.setHeating(200);

        Room room2 = new Room(2,"room2");
        room2.setCube(30);
        room2.setHeating(300);

        level1.addRoom(room1);
        level1.addRoom(room2);

        Level level2 = new Level(211, "level2");
        Room room3 = new Room(3,"room3");
        room3.setCube(40);
        room3.setHeating(400);
        Room room4 = new Room(4,"room4");
        room4.setCube(500);
        room4.setHeating(500);
        level2.addRoom(room3);
        level2.addRoom(room4);

        Building mockBuilding = mock(Building.class);
        when(mockBuilding.getId()).thenReturn(11);
        ArrayList<Level> tmp = new ArrayList<>();
        tmp.add(level1);
        tmp.add(level2);
        when(mockBuilding.getLevels()).thenReturn(tmp);

        testedVisitor.visitBuilding(mockBuilding);
        assertEquals(10,testedVisitor.getHeating());
    }

    @Test
    void visitLevelTest() {
        Room room1 = new Room(1,"room1");
        room1.setCube(20);
        room1.setHeating(200);
        Room room2 = new Room(2,"room2");
        room2.setCube(30);
        room2.setHeating(300);
        Level mockLevel = mock(Level.class);
        when(mockLevel.getId()).thenReturn(11);
        ArrayList<Room> tmp = new ArrayList<>();
        tmp.add(room1);
        tmp.add(room2);
        when(mockLevel.getRooms()).thenReturn(tmp);

        testedVisitor.visitLevel(mockLevel, false);
        assertEquals(10, testedVisitor.getHeating());
    }

}