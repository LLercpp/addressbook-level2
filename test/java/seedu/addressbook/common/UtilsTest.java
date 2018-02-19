package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void isAnyNullTest() {
        //Test non empty list
        assertFalse(Utils.isAnyNull("", "1",  "12", 123, new Object()));
        assertFalse(Utils.isAnyNull(new Object()));
        //Test empty list
        assertFalse(Utils.isAnyNull());

        //Test non empty list with null
        assertTrue(Utils.isAnyNull(null));
        assertTrue(Utils.isAnyNull(null, null, null, null));
        assertTrue(Utils.isAnyNull("", "1", "12", 123, null));
        assertTrue(Utils.isAnyNull("", "1", "12", null, 123));
        assertTrue(Utils.isAnyNull(null, "", "1", "12", 123));
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
