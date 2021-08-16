package com.bcp.monitoring.dto.test;

import com.bcp.monitoring.model.Anomalie;
import com.bcp.monitoring.model.Api;
import com.bcp.monitoring.model.Context;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new TestDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        TestDto testDto = new TestDto();

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertTrue(testDto.canEqual(testDto1));
    }

    @Test
    void testConstructor() {
        TestDto actualTestDto = new TestDto();
        actualTestDto.setId(123L);
        actualTestDto.setInterval(42L);
        ArrayList<Api> apiList = new ArrayList<Api>();
        actualTestDto.setListAPIs(apiList);
        actualTestDto.setName("Name");
        assertEquals(123L, actualTestDto.getId().longValue());
        assertEquals(42L, actualTestDto.getInterval().longValue());
        assertSame(apiList, actualTestDto.getListAPIs());
        assertEquals("Name", actualTestDto.getName());
        assertEquals("TestDto(id=123, name=Name, interval=42, listAPIs=[])", actualTestDto.toString());
    }

    @Test
    void testEquals() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        assertNotEquals(null,testDto);
    }

    @Test
    void testEquals10() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName(null);

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertNotEquals(testDto,testDto1);

        //////
        TestDto testDto2 = new TestDto();
        testDto2.setListAPIs(new ArrayList<Api>());
        testDto2.setInterval(42L);
        testDto2.setId(123L);
        testDto2.setName("com.bcp.monitoring.dto.test.TestDto");

        TestDto testDto3 = new TestDto();
        testDto3.setListAPIs(new ArrayList<Api>());
        testDto3.setInterval(42L);
        testDto3.setId(123L);
        testDto3.setName("Name");
        assertNotEquals(testDto2,testDto3);
        //////
    }



    @Test
    void testEquals2() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        assertNotEquals("Different type to TestDto",testDto);

    }

    @Test
    void testEquals3() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        assertEquals(testDto,testDto);
        int expectedHashCodeResult = testDto.hashCode();
        assertEquals(expectedHashCodeResult, testDto.hashCode());
    }

    @Test
    void testEquals4() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");assertEquals(testDto,testDto1);
        int expectedHashCodeResult = testDto.hashCode();
        assertEquals(expectedHashCodeResult, testDto1.hashCode());
    }

    @Test
    void testEquals5() {
        Api api = new Api();
        api.setPort(8080);
        api.setIp("127.0.0.1");
        api.setStatus(true);
        api.setDb(true);
        api.setPing(true);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(true);
        api.setToken("ABC123");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());

        ArrayList<Api> apiList = new ArrayList<Api>();
        apiList.add(api);

        TestDto testDto = new TestDto();
        testDto.setListAPIs(apiList);
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertNotEquals(testDto,testDto1);
    }

    @Test
    void testEquals6() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(0L);
        testDto.setId(123L);
        testDto.setName("Name");

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertNotEquals(testDto,testDto1);
    }

    @Test
    void testEquals7() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(null);
        testDto.setId(123L);
        testDto.setName("Name");

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertNotEquals(testDto,testDto1);
    }

    @Test
    void testEquals8() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(0L);
        testDto.setName("Name");

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertNotEquals(testDto,testDto1);
    }

    @Test
    void testEquals9() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(null);
        testDto.setName("Name");

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertNotEquals(testDto,testDto1);
    }
}

