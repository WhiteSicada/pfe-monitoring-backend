package com.bcp.monitoring.configuration.actuatordeserialisation;

import lombok.Data;

public @Data
class Root {
    private String status;
    private Component components;
}
