package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PojoTest {

    @Test
    public void when_object_to_string_has_proper_name() {

        // given
        Object obj = new Object();
        // act
        String string = obj.toString();
        // assert
        assertTrue(string.contains("java.lang.Object"));
    }
}
