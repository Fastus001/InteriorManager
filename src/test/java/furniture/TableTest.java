package furniture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    Table table;

    @BeforeEach
    void setUp() {
        table = new Table(2.45,1.2,0.7,0.9);
    }

    @Test
    void area() {
        assertEquals(0.84,table.area());
    }

    @Test
    void show() {
        assertEquals("Table, length: 1,20, width: 0,70, height: 0,90, price: 2,45.",table.show());
    }
}