package com.bcp.monitoring.configuration.actuatordeserialisation.diskspace;

import lombok.Data;

public @Data class Details {
    private String total;
    private String free;
    private String threshold;
    private String exists;
}
