package com.bcp.monitoring.configuration.actuatordeserialisation.diskspace;

import lombok.Data;

public @Data class Diskspace {
    private String status;
    private Details details;
}
