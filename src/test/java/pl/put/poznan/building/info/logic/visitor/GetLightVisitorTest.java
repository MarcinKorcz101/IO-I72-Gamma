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

class GetLightVisitorTest{
    private GetLightVisitor testedVisitor;

    @BeforeEach
    public void setUp(){
        testedVisitor = new GetLightVisitor(11);
    }

    /**
     * This test checks if getLightVisitor's getLight() method when no location was visited returns NumberFormatException (dividing by zero)
     */
    @Test
    void getLightThrowsExceptionTest(){
        assertThrows(java.lang.NumberFormatException.class,() -> {testedVisitor.getLight();});
    }

    @Test
    void visitBuildingTest() {
        Level level1 = new Level(111, "level1");
        Room room1 = new Room(1,"room1");
        room1.setArea(20);
        room1.setLight(200);
        Room room2 = new Room(2,"room2");
        room2.setArea(30);
        room2.setLight(300);
        level1.addRoom(room1);
        level1.addRoom(room2);

        Level level2 = new Level(211, "level2");
        Room room3 = new Room(3,"room3");
        room3.setArea(40);
        room3.setLight(400);
        Room room4 = new Room(4,"room4");
        room4.setArea(50);
        room4.setLight(500);
        level2.addRoom(room3);
        level2.addRoom(room4);

        Building mockBuilding = mock(Building.class);
        when(mockBuilding.getId()).thenReturn(11);
        ArrayList<Level> tmp = new ArrayList<>();
        tmp.add(level1);
        tmp.add(level2);
        when(mockBuilding.getLevels()).thenReturn(tmp);

        testedVisitor.visitBuilding(mockBuilding);
        assertEquals(10,testedVisitor.getLight());
    }

    @Test
    void visitLevelTest() {
        Room room1 = new Room(1,"room1");
        room1.setArea(20);
        room1.setLight(200);
        Room room2 = new Room(2,"room2");
        room2.setArea(30);
        room2.setLight(300);
        Level mockLevel = mock(Level.class);
        when(mockLevel.getId()).thenReturn(11);
        ArrayList<Room> tmp = new ArrayList<>();
        tmp.add(room1);
        tmp.add(room2);
        when(mockLevel.getRooms()).thenReturn(tmp);

        testedVisitor.visitLevel(mockLevel, false);
        assertEquals(10, testedVisitor.getLight());
    }

}