import comparus.test.LongMap;
import comparus.test.LongMapImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringMap {
    private LongMap<String> resultMap = new LongMapImpl<>();
    private String[] string = new String[26];

    void fillMap(){

        resultMap.clear();

        int k = 0;

        for(char ch = 'a'; ch <= 'z'; ch++)
        {
            string[k++] = String.valueOf(ch);
        }

        for (int i = 0; i < string.length; i++) {
            resultMap.put(i, string[i]);
        }
    }

    @Test
    @DisplayName("Test of put and isEmpty")
    public void testPutIsEmpty(){

        fillMap();

        assertFalse(resultMap.isEmpty());
        assertEquals(resultMap.size(), string.length);

    }

    @Test
    @DisplayName("Test of ContainsKey and ContainsValue")
    public void testContainsKeyValue(){

        fillMap();

        for (int i = 0; i < string.length; i++) {
            assertTrue(resultMap.containsKey(i));
            assertTrue(resultMap.containsValue(string[i]));
        }

    }

    @Test
    @DisplayName("Test of get")
    public void testGet(){

        fillMap();

        for (int i = 0; i < string.length; i++) {
            assertEquals(resultMap.get(i), string[i]);
        }
    }

    @Test
    @DisplayName("Test of remove")
    public void testRemove(){

        fillMap();

        resultMap.remove(0);
        resultMap.remove(1);

        assertFalse(resultMap.containsValue("a"));
        assertFalse(resultMap.containsValue("b"));
        assertTrue(resultMap.containsValue("c"));


    }

    @Test
    @DisplayName("Test of keys array")
    public void testKeysArray(){

        fillMap();

        long[] pattern = new long[string.length];
        for (int i = 0; i < string.length; i++) {
            pattern[i] = i;
        }
        long[] keys = resultMap.keys();

        assertEquals(keys.length, resultMap.size());

        assertArrayEquals(pattern, keys);

        for (int i = 0; i < string.length; i++) {
            assertTrue(resultMap.containsKey(keys[i]));
        }
    }

    @Test
    @DisplayName("Test of values array")
    public void testValuesArray(){

        fillMap();

        Object[] values = resultMap.values();

        assertArrayEquals(string, values);


    }

    @Test
    @DisplayName("Test of size")
    public void testSize(){

        fillMap();

        assertEquals(resultMap.size(), string.length);
        resultMap.clear();
        assertEquals(resultMap.size(),0);
    }

    @Test
    @DisplayName("Test of clear")
    public void testClear(){

        resultMap.clear();

        assertArrayEquals(resultMap.keys(), new long[0]);
        assertArrayEquals(resultMap.values(), new String[0]);

        assertEquals(resultMap.size(),0);
    }

}
