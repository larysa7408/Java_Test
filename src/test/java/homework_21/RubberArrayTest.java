package homework_21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * AIT-TR, cohort 42.1, Java Basic, hm # 21
 *
 * @author Larysa Buga
 * @version 03-Mar-2024
 */

public class RubberArrayTest {
    private RubberArray rubberArray;


    @Test
    public void testAddGet() {
        RubberArray rubberArray = new RubberArray();
        rubberArray.add(1);
        rubberArray.add(2);
        rubberArray.add(3);
        Assertions.assertEquals(1, rubberArray.get(0));
        Assertions.assertEquals(2, rubberArray.get(1));
        Assertions.assertEquals(3, rubberArray.get(2));
    }

    @Test
    public void testAddAtIndex() {
        RubberArray rubberArray = new RubberArray();
        rubberArray.add(1);
        rubberArray.add(3);
        rubberArray.add(5);
        rubberArray.add(1, 1);
        Assertions.assertEquals(3, rubberArray.get(2));
    }

    @Test
    public void testRemove() {
        RubberArray rubberArray = new RubberArray();
        rubberArray.add(1);
        rubberArray.add(2);
        rubberArray.add(3);
        rubberArray.remove(1);
        Assertions.assertEquals(1, rubberArray.get(0));
        Assertions.assertEquals(3, rubberArray.get(1));
    }

    @Test
    public void testContains() {
        RubberArray rubberArray = new RubberArray();
        rubberArray.add(1);
        rubberArray.add(2);
        rubberArray.add(3);
        Assertions.assertTrue(rubberArray.contains(2));
        Assertions.assertFalse(rubberArray.contains(4));
    }

    @Test
    public void testIndexOf() {
        RubberArray rubberArray = new RubberArray();
        rubberArray.add(1);
        rubberArray.add(2);
        rubberArray.add(3);
        Assertions.assertEquals(1, rubberArray.indexOf(2));
        Assertions.assertEquals(-1, rubberArray.indexOf(4));
    }

    @Test
    public void testToString() {
        RubberArray rubberArray = new RubberArray();
        rubberArray.add(-1);
        rubberArray.add(3);
        Assertions.assertEquals("[-1, 3]", rubberArray.toString());

    }
}
