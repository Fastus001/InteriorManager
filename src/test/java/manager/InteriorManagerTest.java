package manager;

import exceptions.ExceededRoomAreaException;
import furniture.Furniture;
import furniture.SquareCabinet;
import furniture.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import room.RectangularRoom;

import static org.junit.jupiter.api.Assertions.*;

class InteriorManagerTest {
    InteriorManager manager;

    @BeforeEach
    void setUp() {
        manager = new InteriorManager();
    }

    @Test
    void fun() {
    }

    @Test
    void addRoomWithFurniture() throws ExceededRoomAreaException {
        RectangularRoom room = new RectangularRoom(2.5, 3.5);
        Furniture t1 = new Table(2.25,0.7,1.2,1.1);
        Furniture t2 = new Table(2.25,0.7,1.2,1.1);
        Furniture sqC = new SquareCabinet(12.1,1.5);

        manager.addRoomWithFurniture(room,t1,t2,sqC);
        manager.showAllResources();
    }

    @Test
    void shouldThrowExceptionWhenExceedArea() {
        RectangularRoom room = new RectangularRoom(2.5, 3.5);
        Furniture t1 = new Table(2.25,1.0,1.75,1.1);
        Furniture t2 = new Table(2.25,1.0,1.75,1.1);
        Furniture sqC = new SquareCabinet(12.1,2.3);


        assertThrows(ExceededRoomAreaException.class,()->manager.addRoomWithFurniture(room,t1,t2,sqC));

    }


    @Test
    void countRoomsTotalArea() throws ExceededRoomAreaException {
        RectangularRoom room = new RectangularRoom(2.5, 3.5);
        RectangularRoom room1 = new RectangularRoom(2.5, 3.5);
        RectangularRoom room2 = new RectangularRoom(2.5, 3.5);
        Furniture t1 = new Table(2.25,1.0,1.75,1.1);

        manager.addRoomWithFurniture(room,t1);
        manager.addRoomWithFurniture(room1);
        manager.addRoomWithFurniture(room2,t1,t1);
        manager.addFurniture(t1);

        manager.showAllResources();
        assertEquals(26.25, manager.countRoomsTotalArea());
    }


}