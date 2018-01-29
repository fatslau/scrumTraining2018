package org.ruler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.ruler.Length.feet;
import static org.ruler.Length.inch;
import static org.ruler.Length.mile;
import static org.ruler.Length.yard;

public class LengthTest {

    @Test
    public void length_with_same_type_has_same_value_should_equal() throws Exception {
        assertEquals(mile(3), mile(3));
    }

    @Test
    public void length_with_same_type_has_different_value_should_not_equal() throws Exception {
        assertNotEquals(mile(3), mile(4));
        assertNotEquals(mile(3), mile(2));
    }

    @Test
    public void length_not_equals_to_null() throws Exception {
        assertNotEquals(mile(3), null);
    }

    @Test
    public void null_not_equal_to_length() throws Exception {
        assertNotEquals(null, mile(3));
    }

    @Test
    public void one_mile_equals_1760_yard() throws Exception {
        assertEquals(mile(1), yard(1760));
    }

    @Test
    public void one_mile_not_equal_1761_yard() throws Exception {
        assertNotEquals(mile(1), yard(1761));
    }

    @Test
    public void test_1760_yard_equals_1_mile() throws Exception {
        assertEquals(yard(1760), mile(1));
    }

    @Test
    public void test_1761_yard_not_equals_1_mile() throws Exception {
        assertNotEquals(yard(1761), mile(1));
    }

    @Test
    public void one_yard_equals_three_feet() throws Exception {
        assertEquals(yard(1), feet(3));
    }

    @Test
    public void one_feet_equals_12_inch() throws Exception {
        assertEquals(feet(1), inch(12));
    }

    @Test
    public void one_mile_equals_5280_feet() throws Exception {
        assertEquals(mile(1), feet(5280));
    }

    @Test
    public void one_mile_equals_63360_inch() throws Exception {
        assertEquals(mile(1), inch(63360));
    }
}
