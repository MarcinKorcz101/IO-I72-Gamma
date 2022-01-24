package pl.put.poznan.building.info.logic.composit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.put.poznan.building.info.logic.visitor.GetCubeVisitor;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private static Room testedRoom;

    @BeforeAll
    public static void setUp(){
        testedRoom = new Room(10, "testedRoom");
        testedRoom.setArea(100);
        testedRoom.setCube(1000);
        testedRoom.setHeating(2500);
        testedRoom.setLight(20000);
    }

    @Test
    void getArea() {
        assertEquals(100, testedRoom.getArea());
    }


    @Test
    void getCube() {
        assertEquals(1000, testedRoom.getCube());
    }


    @Test
    void getHeating() {
        assertEquals(2500, testedRoom.getHeating());
    }


    @Test
    void getLight() {
        assertEquals(20000, testedRoom.getLight());
    }


    @Test
    void accept() {
        GetCubeVisitor cubeVisitor = new GetCubeVisitor(111);
        testedRoom.accept(cubeVisitor);
        cubeVisitor.visitRoom(testedRoom, true);
        assertEquals(1000, cubeVisitor.getCube());
    }

    @Test
    void getId(){
        assertEquals(testedRoom.getId(),10);
    }

    @Test
    void getName(){
        assertEquals(testedRoom.getName(),"testedRoom");
    }


}