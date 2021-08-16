package com.bcp.monitoring.configuration.actuatordeserialisation.db;

import lombok.Data;

public @Data
class Details {
    private String database;
    private String validationQuery;
}
