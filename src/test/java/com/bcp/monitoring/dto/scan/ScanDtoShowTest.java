package com.bcp.monitoring.dto.scan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScanDtoShowTest {
    @Test
    void testCanEqual() {
        assertFalse((new ScanDtoShow()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertTrue(scanDtoShow.canEqual(scanDtoShow1));
    }

    @Test
    void testConstructor() {
        ScanDtoShow actualScanDtoShow = new ScanDtoShow();
        actualScanDtoShow.setApi("Api");
        actualScanDtoShow.setCreatesAt("Creates At");
        actualScanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        actualScanDtoShow.setExecutionTime("Execution Time");
        actualScanDtoShow.setId(123L);
        actualScanDtoShow.setMethod("Method");
        actualScanDtoShow.setSpark("Spark");
        actualScanDtoShow.setStatus("Status");
        actualScanDtoShow.setSuccessful("Successful");
        actualScanDtoShow.setTest("Test");
        actualScanDtoShow.setUrl("https://example.org/example");
        assertEquals("Api", actualScanDtoShow.getApi());
        assertEquals("Creates At", actualScanDtoShow.getCreatesAt());
        assertEquals("https://config.us-east-2.amazonaws.com", actualScanDtoShow.getEndpoint());
        assertEquals("Execution Time", actualScanDtoShow.getExecutionTime());
        assertEquals(123L, actualScanDtoShow.getId().longValue());
        assertEquals("Method", actualScanDtoShow.getMethod());
        assertEquals("Spark", actualScanDtoShow.getSpark());
        assertEquals("Status", actualScanDtoShow.getStatus());
        assertEquals("Successful", actualScanDtoShow.getSuccessful());
        assertEquals("Test", actualScanDtoShow.getTest());
        assertEquals("https://example.org/example", actualScanDtoShow.getUrl());
        assertEquals(
                "ScanDtoShow(id=123, api=Api, test=Test, endpoint=https://config.us-east-2.amazonaws.com, status=Status,"
                        + " spark=Spark, successful=Successful, executionTime=Execution Time, createsAt=Creates At, method=Method,"
                        + " url=https://example.org/example)",
                actualScanDtoShow.toString());
    }

    @Test
    void testEquals() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");
        assertNotEquals(null,scanDtoShow);
    }

    @Test
    void testEquals10() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus(null);
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals11() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi(null);
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals12() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Test");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals13() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("Api");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals14() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl(null);
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals15() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(0L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals16() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(null);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals17() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("Api");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals18() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint(null);
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals19() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Api");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals2() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");
        assertNotEquals("Different type to ScanDtoShow",scanDtoShow);
    }

    @Test
    void testEquals20() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt(null);
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals21() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Api");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals22() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful(null);
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals23() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Api");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals24() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod(null);
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals25() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Api");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals26() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest(null);

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals3() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");
        assertEquals(scanDtoShow,scanDtoShow);
        int expectedHashCodeResult = scanDtoShow.hashCode();
        assertEquals(expectedHashCodeResult, scanDtoShow.hashCode());
    }

    @Test
    void testEquals4() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertEquals(scanDtoShow,scanDtoShow1);
        int expectedHashCodeResult = scanDtoShow.hashCode();
        assertEquals(expectedHashCodeResult, scanDtoShow1.hashCode());
    }

    @Test
    void testEquals5() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Api");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals6() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime(null);
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals7() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Api");
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals8() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark(null);
        scanDtoShow.setStatus("Status");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }

    @Test
    void testEquals9() {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setExecutionTime("Execution Time");
        scanDtoShow.setSpark("Spark");
        scanDtoShow.setStatus("Api");
        scanDtoShow.setApi("Api");
        scanDtoShow.setUrl("https://example.org/example");
        scanDtoShow.setId(123L);
        scanDtoShow.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow.setCreatesAt("Creates At");
        scanDtoShow.setSuccessful("Successful");
        scanDtoShow.setMethod("Method");
        scanDtoShow.setTest("Test");

        ScanDtoShow scanDtoShow1 = new ScanDtoShow();
        scanDtoShow1.setExecutionTime("Execution Time");
        scanDtoShow1.setSpark("Spark");
        scanDtoShow1.setStatus("Status");
        scanDtoShow1.setApi("Api");
        scanDtoShow1.setUrl("https://example.org/example");
        scanDtoShow1.setId(123L);
        scanDtoShow1.setEndpoint("https://config.us-east-2.amazonaws.com");
        scanDtoShow1.setCreatesAt("Creates At");
        scanDtoShow1.setSuccessful("Successful");
        scanDtoShow1.setMethod("Method");
        scanDtoShow1.setTest("Test");
        assertNotEquals(scanDtoShow,scanDtoShow1);
    }
}

