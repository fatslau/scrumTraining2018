package org.ruler;

import org.junit.Test;
import org.DistanceUnit.*;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;

public class MileTest {

    @Test
    public void three_miles_shd_equal_three_miles() {
        assertEquals(new Mile(3),new Mile(3));
    }

    @Test
    public void three_miles_shd_not_equal_two_miles() {
        assertNotSame(new Mile(3),new Mile(2));
    }

    @Test
    public void one_miles_shd_equal_1760_yard() {
        assertEquals(new Mile(1),new Yard(1760));
    }

    @Test
    public void three_miles_shd_not_equal_three_yard() {
        assertNotSame(new Mile(3),new Yard(3));
    }
}
