package com.bcp.monitoring.convertor;

import com.bcp.monitoring.dto.scan.ScanDtoShow;
import com.bcp.monitoring.model.Scan;
import com.bcp.monitoring.repository.ApiRepository;
import com.bcp.monitoring.repository.EndpointRepository;
import com.bcp.monitoring.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScanConvertor {

    @Autowired
    public ApiRepository apiRepository;

    @Autowired
    public EndpointRepository endpointRepository;

    @Autowired
    public TestRepository testRepository;

    public ScanDtoShow entityToDoto(Scan scan) {
        ScanDtoShow scanDtoShow = new ScanDtoShow();
        scanDtoShow.setId(scan.getId());
        scanDtoShow.setApi(scan.getApi());
        scanDtoShow.setTest(scan.getTest());
        scanDtoShow.setStatus(scan.getStatus());
        scanDtoShow.setSpark(scan.getSpark());
        scanDtoShow.setSuccessful(scan.getSuccessful());
        scanDtoShow.setExecutionTime(scan.getExecutionTime());
        scanDtoShow.setCreatesAt(scan.getCreatesAt());
        scanDtoShow.setMethod(scan.getMethod());
        scanDtoShow.setUrl(scan.getUrl());

        return scanDtoShow;
    }

    public List<ScanDtoShow> entitiesToDotos(List<Scan> scanList) {
        return scanList.stream().map(this::entityToDoto).collect(Collectors.toList());
    }


}
