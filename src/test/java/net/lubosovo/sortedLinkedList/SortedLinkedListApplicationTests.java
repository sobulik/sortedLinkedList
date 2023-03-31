package net.lubosovo.sortedLinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class SortedLinkedListApplicationTests {

    SortedLinkedList<Integer> i_0, i_1, i_2;
    SortedLinkedList<String> s_0;

    @BeforeEach
    void beforeEach() {
        i_0 = new SortedLinkedList<>();
        i_1 = new SortedLinkedList<>(Arrays.asList(5));
        i_2 = new SortedLinkedList<>(Arrays.asList(2, 4, 6, 4));
        s_0 = new SortedLinkedList<>(Arrays.asList("foo", "bar", "baz"));
    }

    @AfterEach
    void afterEach() {
        i_0 = null;
        i_1 = null;
        i_2 = null;
        s_0 = null;
    }

    @Test
    void testSize_i_0() {
        assertEquals(0, i_0.size());
    }

    @Test
    void testSize_i_1() {
        assertEquals(1, i_1.size());
    }

    @Test
    void testSize_i_2() {
        assertEquals(4, i_2.size());
    }

    @Test
    void testSize_s_0() {
        assertEquals(3, s_0.size());
    }

    @Test
    void testGet_i_0() {
        assertThrows(IndexOutOfBoundsException.class, () -> i_0.get(0));
    }

    @Test
    void testGet_i_1() {
        assertEquals(5, i_1.get(0));
    }

    @Test
    void testGet_i_2() {
        assertEquals(2, i_2.get(0));
        assertEquals(4, i_2.get(1));
        assertEquals(4, i_2.get(2));
        assertEquals(6, i_2.get(3));
    }

    @Test
    void testGet_s_0() {
        assertEquals("bar", s_0.get(0));
        assertEquals("baz", s_0.get(1));
        assertEquals("foo", s_0.get(2));
    }

    @Test
    void testContains_i_0() {
        assertFalse(i_0.contains(5));
    }

    @Test
    void testContains_i_1() {
        assertTrue(i_1.contains(5));
    }

    @Test
    void testContains_i_2() {
        assertFalse(i_2.contains(0));
        assertFalse(i_2.contains(1));
        assertTrue(i_2.contains(2));
        assertFalse(i_2.contains(3));
        assertTrue(i_2.contains(4));
        assertFalse(i_2.contains(5));
        assertTrue(i_2.contains(6));
        assertFalse(i_2.contains(7));
    }

    @Test
    void testContains_s_0() {
        assertFalse(s_0.contains("bad"));
    }

    @Test
    void testAdd_i_0() {
        i_0.add(3);
        assertEquals(1, i_0.size());
        assertEquals(3, i_0.get(0));
    }

    @Test
    void testAddOne_i_1() {
        i_2.add(1);
        assertEquals(5, i_2.size());
        assertEquals(1, i_2.get(0));
        assertEquals(2, i_2.get(1));
        assertEquals(4, i_2.get(2));
        assertEquals(4, i_2.get(3));
        assertEquals(6, i_2.get(4));
    }

    @Test
    void testAddFour_i_1() {
        i_2.add(4);
        assertEquals(5, i_2.size());
        assertEquals(2, i_2.get(0));
        assertEquals(4, i_2.get(1));
        assertEquals(4, i_2.get(2));
        assertEquals(4, i_2.get(3));
        assertEquals(6, i_2.get(4));
    }

    @Test
    void testAddTen_i_1() {
        i_2.add(10);
        assertEquals(5, i_2.size());
        assertEquals(2, i_2.get(0));
        assertEquals(4, i_2.get(1));
        assertEquals(4, i_2.get(2));
        assertEquals(6, i_2.get(3));
        assertEquals(10, i_2.get(4));
    }

    @Test
    void testAddBat_s_0() {
        s_0.add("bat");
        assertEquals(4, s_0.size());
        assertEquals("bar", s_0.get(0));
        assertEquals("bat", s_0.get(1));
        assertEquals("baz", s_0.get(2));
        assertEquals("foo", s_0.get(3));
    }

    @Test
    void testRemove_i_0() {
        assertThrows(IndexOutOfBoundsException.class, () -> i_0.remove(0));
    }

    @Test
    void testRemoveFirst_i_1() {
        Integer i = i_1.remove(0);
        assertEquals(5, i);
        assertEquals(0, i_1.size());
    }

    @Test
    void testRemoveSecond_i_1() {
        assertThrows(IndexOutOfBoundsException.class, () -> i_1.remove(1));
    }

    @Test
    void testRemoveThird_i_1() {
        assertThrows(IndexOutOfBoundsException.class, () -> i_1.remove(2));
    }

    @Test
    void testRemoveFirst_i_2() {
        Integer i = i_2.remove(0);
        assertEquals(2, i);
        assertEquals(3, i_2.size());
    }

    @Test
    void testRemoveFourth_i_2() {
        Integer i = i_2.remove(3);
        assertEquals(6, i);
        assertEquals(3, i_2.size());
    }

    @Test
    void testRemoveFours_i_2() {
        Integer i = i_2.remove(2);
        assertEquals(4, i);
        i = i_2.remove(1);
        assertEquals(2, i_2.size());
        assertEquals(6, i_2.get(1));
    }

    @Test
    void testRemoveFirst_s_0() {
        String s = s_0.remove(0);
        assertEquals("bar", s);
        assertEquals(2, s_0.size());
        assertEquals("baz", s_0.get(0));
        assertEquals("foo", s_0.get(1));
    }
}
