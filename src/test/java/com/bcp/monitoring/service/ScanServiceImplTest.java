package com.bcp.monitoring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.convertor.ScanConvertor;
import com.bcp.monitoring.dto.scan.ScanDtoShow;
import com.bcp.monitoring.email.MailRequest;
import com.bcp.monitoring.email.MailResponse;
import com.bcp.monitoring.model.Anomalie;
import com.bcp.monitoring.model.Api;
import com.bcp.monitoring.model.Context;
import com.bcp.monitoring.model.Endpoint;
import com.bcp.monitoring.model.Scan;
import com.bcp.monitoring.repository.ApiRepository;
import com.bcp.monitoring.repository.ProjetRepository;
import com.bcp.monitoring.repository.ScanRepository;
import com.bcp.monitoring.repository.TestRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Configuration.class, ScanConvertor.class, ScanServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class ScanServiceImplTest {
    @MockBean
    private ApiRepository apiRepository;

    @MockBean
    private Configuration configuration;

    @MockBean
    private JavaMailSender javaMailSender;

    @MockBean
    private ProjetRepository projetRepository;

    @MockBean
    private ScanConvertor scanConvertor;

    @MockBean
    private ScanRepository scanRepository;

    @Autowired
    private ScanServiceImpl scanServiceImpl;

    @MockBean
    private TestRepository testRepository;

    @org.junit.jupiter.api.Test
    public void testScanTest() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);
        assertTrue(this.scanServiceImpl.scanTest(123L).isEmpty());
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.scanServiceImpl.getAllScans().isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testScanTest2() {
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

        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(apiList);
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);
        assertTrue(this.scanServiceImpl.scanTest(123L).isEmpty());
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.scanServiceImpl.getAllScans().isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testScanTest3() {
        when(this.testRepository.findById((Long) any())).thenReturn(Optional.<com.bcp.monitoring.model.Test>empty());
        assertTrue(this.scanServiceImpl.scanTest(123L).isEmpty());
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.scanServiceImpl.getAllScans().isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testScanTest4() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());

        ArrayList<Context> contextList = new ArrayList<Context>();
        contextList.add(context);

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
        api.setContexts(contextList);

        ArrayList<Api> apiList = new ArrayList<Api>();
        apiList.add(api);

        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(apiList);
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);
        assertTrue(this.scanServiceImpl.scanTest(123L).isEmpty());
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.scanServiceImpl.getAllScans().isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testScanTest5() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        ArrayList<Endpoint> endpointList = new ArrayList<Endpoint>();
        endpointList.add(endpoint);

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(endpointList);

        ArrayList<Context> contextList = new ArrayList<Context>();
        contextList.add(context);

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
        api.setContexts(contextList);

        ArrayList<Api> apiList = new ArrayList<Api>();
        apiList.add(api);

        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(apiList);
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals(1, this.scanServiceImpl.scanTest(123L).size());
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.scanServiceImpl.getAllScans().isEmpty());
    }

    @Test
    public void testGetAllScans() {
        when(this.scanRepository.findAllByOrderByIdDesc()).thenReturn(new ArrayList<Scan>());
        ArrayList<ScanDtoShow> scanDtoShowList = new ArrayList<ScanDtoShow>();
        when(this.scanConvertor.entitiesToDotos((List<Scan>) any())).thenReturn(scanDtoShowList);
        List<ScanDtoShow> actualAllScans = this.scanServiceImpl.getAllScans();
        assertSame(scanDtoShowList, actualAllScans);
        assertTrue(actualAllScans.isEmpty());
        verify(this.scanRepository).findAllByOrderByIdDesc();
        verify(this.scanConvertor).entitiesToDotos((List<Scan>) any());
    }

    @Test
    public void testFormatEndpointForUrl() {
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

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());

        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        assertEquals("http://127.0.0.1:8080/Name/https://example.org/example/",
                this.scanServiceImpl.formatEndpointForUrl(api, context, endpoint));
    }

    @org.junit.jupiter.api.Test
    public void testCreateCustomErrorTextForEmail() {
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

        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        assertEquals(
                "The Name API has encountred an error when scanning the endpoint https://example.org/example of the"
                        + " test Name at 2020-03-01 with error message : An error occurred",
                this.scanServiceImpl.createCustomErrorTextForEmail(api, test, "https://example.org/example", "2020-03-01",
                        "An error occurred"));
    }

    @org.junit.jupiter.api.Test
    public void testExecuteRequest() {
        Scan scan = new Scan();
        scan.setExecutionTime("Execution Time");
        scan.setSpark("Spark");
        scan.setStatus("Status");
        scan.setApi("Api");
        scan.setId(123L);
        scan.setUrl("https://example.org/example");
        scan.setCreatesAt("Creates At");
        scan.setSuccessful("Successful");
        scan.setMethod("Method");
        scan.setTest("Test");
        when(this.scanRepository.save((Scan) any())).thenReturn(scan);

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

        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        HttpEntity request = new HttpEntity("Body");
        ArrayList<String> stringList = new ArrayList<String>();
        ArrayList<Anomalie> anomalieList = new ArrayList<Anomalie>();
        assertSame(scan, this.scanServiceImpl.executeRequest(api, test, "https://example.org/example", request,
                HttpMethod.GET, stringList, anomalieList));
        verify(this.scanRepository).save((Scan) any());
        assertEquals(1, stringList.size());
        assertEquals(1, anomalieList.size());
        assertTrue(this.scanServiceImpl.getAllScans().isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testMakeRequest() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");

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

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());

        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        ArrayList<String> listErrorMessagesForEmail = new ArrayList<String>();
        assertNull(this.scanServiceImpl.makeRequest(test, api, context, endpoint, listErrorMessagesForEmail,
                new ArrayList<Anomalie>()));
    }

    @Test
    public void testSendEmail() throws IOException, MessagingException, MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage())
                .thenReturn(new MimeMessage(new MimeMessage(new MimeMessage(new MimeMessage(new MimeMessage((Session) null,
                        new ByteArrayInputStream("AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"))))))));
        when(this.configuration.getTemplate(anyString())).thenReturn(new Template("Name", new StringReader("foo")));
        MailRequest request = new MailRequest("Name", "alice.liddell@example.org", "jane.doe@example.org",
                "Hello from the Dreaming Spires");

        MailResponse actualSendEmailResult = this.scanServiceImpl.sendEmail(request, new HashMap<String, Object>(1));
        assertEquals("mail send to : alice.liddell@example.org", actualSendEmailResult.getMessage());
        assertTrue(actualSendEmailResult.isStatus());
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
        verify(this.configuration).getTemplate(anyString());
        assertTrue(this.scanServiceImpl.getAllScans().isEmpty());
    }
}

