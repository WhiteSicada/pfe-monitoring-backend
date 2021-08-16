package com.bcp.monitoring.configuration.actuatordeserialisation.db;

import lombok.Data;

public @Data
class Db {
    private String status;
    private Details details;
}
