package play;

import exam.leetcode.medium.ValidSudokuTest;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    private static Logger log = LoggerFactory.getLogger(MapTest.class);
    @Test
    public void map_put_duplication_test() {

        Map<String, String> map = new HashMap<>();


        // If there is no value or previous is null then null return
        Assert.assertEquals(null, map.put("A","A"));

        // it snow should return A as its previous value was A
        Assert.assertEquals("A", map.put("A","A"));


        if (map.put("A","A") == "A") {
            log.debug("wow");
        }
    }


    public boolean isValidForBlock(String val, Map<String, String> block_map) {
        String rtn = block_map.put(val, val);
        return (rtn == null || !val.equals(rtn));
    }

    public boolean isValidMap(char val, Map<Character, Character> block_map) {
        Character rtn = block_map.put(val, val);
        return (rtn == null || val != rtn);
    }


    @Test
    public void map_put_duplication_boolean_test() {
        Map<String, String> map = new HashMap<>();
        Map<Character, Character> map_char = new HashMap<>();

        //String rtn = map.put("A", "A");

        log.debug("hoho");


        if (isValidMap('A', map_char)) {
            log.debug("true man");
        }

        if (isValidForBlock("A", map)) {
            log.debug("true man");
        }
//
//
//        Assert.assertEquals(true, isValidForBlock("A", map));
//        Assert.assertEquals(false, isValidForBlock("A", map));


    }


}
