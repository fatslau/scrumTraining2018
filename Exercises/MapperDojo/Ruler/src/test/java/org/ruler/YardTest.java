package org.ruler;

import org.DistanceUnit.Mile;
import org.junit.Test;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;

public class YardTest {

    @Test
    public void three_miles_shd_equal_three_miles() {
        assertEquals(new Mile(3),new Mile(3));
    }

    @Test
    public void three_miles_shd_not_equal_two_miles() {
        assertNotSame(new Mile(3),new Mile(2));
    }
}
