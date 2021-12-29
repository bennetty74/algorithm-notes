package java.org.bugkit.structure;

import org.bugkit.structure.HashMap;
import org.bugkit.structure.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bennetty74
 * @since 2021.10.28
 */
class MapTest {

    private Map<Integer, Integer> map;

    @BeforeEach
    public void setupTest() {
        map = new HashMap<>();
        assertTrue(map.put(1,1));
        assertTrue(map.put(2,2));
    }

    @AfterEach
    public void printTest() {
        System.out.println(map);
    }

    @Test
    void containsTest() {
        assertTrue(map.contains(1));
        assertTrue(map.contains(2));
        assertFalse(map.contains(3));
    }

    @Test
    void putTest() {
        assertTrue(map.put(3,3));
    }

    @Test
    void getTest() {
        assertEquals(1,map.get(1));
        assertEquals(2,map.get(2));
        assertNull(map.get(3));
    }
}