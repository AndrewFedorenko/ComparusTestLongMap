import comparus.test.LongMap;
import comparus.test.LongMapImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestIntegerMap {
    private final int testDimension = 10000;
    private LongMap<Integer> resultMap = new LongMapImpl<>();

    void fillMap(){

        resultMap.clear();

        for (int i = 0; i < testDimension; i++) {
            resultMap.put(i, i);
        }
    }

    @Test
    @DisplayName("Test of put and isEmpty")
    public void testPutIsEmpty(){

        fillMap();

        assertFalse(resultMap.isEmpty());
        assertEquals(resultMap.size(), testDimension);
    }

    @Test
    @DisplayName("Test of ContainsKey and ContainsValue")
    public void testContainsKeyValue(){

        fillMap();

        resultMap.put(testDimension, null);

        assertTrue(resultMap.containsValue(null));

        for (int i = 0; i < testDimension; i++) {
            assertTrue(resultMap.containsKey(i));
            assertTrue(resultMap.containsValue(i));
        }
    }

    @Test
    @DisplayName("Test of get")
    public void testGet(){

        fillMap();

        for (int i = 0; i < testDimension; i++) {
            assertEquals((int) resultMap.get(i), i);
        }
    }

    @Test
    @DisplayName("Test of remove")
    public void testRemove(){

        fillMap();

        for (int i = 0; i < testDimension; i++) {
            assertEquals((int) resultMap.remove(i),i);

            assertFalse(resultMap.containsKey(i));
            assertFalse(resultMap.containsValue(i));
        }
    }

    @Test
    @DisplayName("Test of keys array")
    public void testKeysArray(){

        fillMap();

        long[] keys = resultMap.keys();

        long[] pattern = new long[testDimension];
        for (int i = 0; i < testDimension; i++) {
            pattern[i] = i;
        }

        assertEquals(keys.length, resultMap.size());

        assertArrayEquals(pattern, keys);

        for (int i = 0; i < testDimension; i++) {
            assertTrue(resultMap.containsKey(keys[i]));
        }
    }

    @Test
    @DisplayName("Test of values array")
    public void testValuesArray(){

        fillMap();

        Object[] values = resultMap.values();

        Integer[] pattern = new Integer[testDimension];
        for (int i = 0; i < testDimension; i++) {
            pattern[i] = i;
        }

        assertEquals(values.length, resultMap.size());

        assertArrayEquals(pattern, values);

        for (int i = 0; i < testDimension; i++) {
            assertTrue(resultMap.containsValue((Integer) values[i]));
        }
    }

    @Test
    @DisplayName("Test of size")
    public void testSize(){

        fillMap();

        assertEquals(resultMap.size(), testDimension);
        resultMap.clear();
        assertEquals(resultMap.size(),0);
    }

    @Test
    @DisplayName("Test of clear")
    public void testClear(){

        resultMap.clear();

        assertArrayEquals(resultMap.keys(), new long[0]);
        assertArrayEquals(resultMap.values(), new Integer[0]);

        assertEquals(resultMap.size(),0);
    }
}
