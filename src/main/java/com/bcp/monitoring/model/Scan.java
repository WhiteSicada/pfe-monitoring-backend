package com.bcp.monitoring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "scan")
public class Scan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String api;
    private String test;
    private String status;
    private String spark;
    private String successful;
    private String executionTime;
    private String createsAt;
    private String method;
    private String url;

    public Scan() {
        // constructor
    }

    public Scan(String api, String test, String status, String spark, String successful, String executionTime, String createsAt, String method, String url) {
        this.api = api;
        this.test = test;
        this.status = status;
        this.spark = spark;
        this.successful = successful;
        this.executionTime = executionTime;
        this.createsAt = createsAt;
        this.method = method;
        this.url = url;
    }
}
