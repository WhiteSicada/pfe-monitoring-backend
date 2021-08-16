package com.bcp.monitoring.dto.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDtoUpdateTest {
    @Test
    void testCanEqual() {
        assertFalse((new TestDtoUpdate()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(42L);
        testDtoUpdate1.setId(123L);
        testDtoUpdate1.setName("Name");
        assertTrue(testDtoUpdate.canEqual(testDtoUpdate1));
    }

    @Test
    void testConstructor() {
        TestDtoUpdate actualTestDtoUpdate = new TestDtoUpdate();
        actualTestDtoUpdate.setId(123L);
        actualTestDtoUpdate.setInterval(42L);
        actualTestDtoUpdate.setName("Name");
        assertEquals(123L, actualTestDtoUpdate.getId().longValue());
        assertEquals(42L, actualTestDtoUpdate.getInterval().longValue());
        assertEquals("Name", actualTestDtoUpdate.getName());
        assertEquals("TestDtoUpdate(id=123, name=Name, interval=42)", actualTestDtoUpdate.toString());
    }

    @Test
    void testEquals() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(123L);
        testDtoUpdate.setName("Name");assertNotEquals(null,testDtoUpdate);
    }

    @Test
    void testEquals10() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(123L);
        testDtoUpdate.setName("com.bcp.monitoring.dto.test.TestDtoUpdate");

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(42L);
        testDtoUpdate1.setId(123L);
        testDtoUpdate1.setName("Name");
        assertNotEquals(testDtoUpdate,testDtoUpdate1);

        /////
        TestDtoUpdate testDtoUpdate2 = new TestDtoUpdate();
        testDtoUpdate2.setInterval(0L);
        testDtoUpdate2.setId(123L);
        testDtoUpdate2.setName("Name");

        TestDtoUpdate testDtoUpdate3 = new TestDtoUpdate();
        testDtoUpdate3.setInterval(42L);
        testDtoUpdate3.setId(123L);
        testDtoUpdate3.setName("Name");
        assertNotEquals(testDtoUpdate2,testDtoUpdate3);
    }

    @Test
    void testEquals11() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(null);
        testDtoUpdate.setId(123L);
        testDtoUpdate.setName("Name");

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(null);
        testDtoUpdate1.setId(123L);
        testDtoUpdate1.setName("Name");
        assertEquals(testDtoUpdate,testDtoUpdate1);
        int expectedHashCodeResult = testDtoUpdate.hashCode();
        assertEquals(expectedHashCodeResult, testDtoUpdate1.hashCode());
    }

    @Test
    void testEquals12() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(null);
        testDtoUpdate.setName("Name");

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(42L);
        testDtoUpdate1.setId(null);
        testDtoUpdate1.setName("Name");
        assertEquals(testDtoUpdate,testDtoUpdate1);
        int expectedHashCodeResult = testDtoUpdate.hashCode();
        assertEquals(expectedHashCodeResult, testDtoUpdate1.hashCode());
    }

    @Test
    void testEquals13() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(123L);
        testDtoUpdate.setName(null);

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(42L);
        testDtoUpdate1.setId(123L);
        testDtoUpdate1.setName(null);
        assertEquals(testDtoUpdate,testDtoUpdate1);
        int expectedHashCodeResult = testDtoUpdate.hashCode();
        assertEquals(expectedHashCodeResult, testDtoUpdate1.hashCode());
    }

    @Test
    void testEquals2() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(123L);
        testDtoUpdate.setName("Name");
        assertNotEquals("Different type to TestDtoUpdate",testDtoUpdate);

    }

    @Test
    void testEquals3() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(123L);
        testDtoUpdate.setName("Name");
        assertEquals(testDtoUpdate,testDtoUpdate);
        int expectedHashCodeResult = testDtoUpdate.hashCode();
        assertEquals(expectedHashCodeResult, testDtoUpdate.hashCode());
    }

    @Test
    void testEquals4() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(123L);
        testDtoUpdate.setName("Name");

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(42L);
        testDtoUpdate1.setId(123L);
        testDtoUpdate1.setName("Name");
        assertEquals(testDtoUpdate,testDtoUpdate1);
        int expectedHashCodeResult = testDtoUpdate.hashCode();
        assertEquals(expectedHashCodeResult, testDtoUpdate1.hashCode());
    }



    @Test
    void testEquals6() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(null);
        testDtoUpdate.setId(123L);
        testDtoUpdate.setName("Name");

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(42L);
        testDtoUpdate1.setId(123L);
        testDtoUpdate1.setName("Name");
        assertNotEquals(testDtoUpdate,testDtoUpdate1);
    }

    @Test
    void testEquals7() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(0L);
        testDtoUpdate.setName("Name");

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(42L);
        testDtoUpdate1.setId(123L);
        testDtoUpdate1.setName("Name");
        assertNotEquals(testDtoUpdate,testDtoUpdate1);
    }

    @Test
    void testEquals8() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(null);
        testDtoUpdate.setName("Name");

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(42L);
        testDtoUpdate1.setId(123L);
        testDtoUpdate1.setName("Name");
        assertNotEquals(testDtoUpdate,testDtoUpdate1);
    }

    @Test
    void testEquals9() {
        TestDtoUpdate testDtoUpdate = new TestDtoUpdate();
        testDtoUpdate.setInterval(42L);
        testDtoUpdate.setId(123L);
        testDtoUpdate.setName(null);

        TestDtoUpdate testDtoUpdate1 = new TestDtoUpdate();
        testDtoUpdate1.setInterval(42L);
        testDtoUpdate1.setId(123L);
        testDtoUpdate1.setName("Name");
        assertNotEquals(testDtoUpdate,testDtoUpdate1);
    }
}

