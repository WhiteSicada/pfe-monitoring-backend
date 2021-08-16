package com.bcp.monitoring.configuration.actuatordeserialisation;

import com.bcp.monitoring.configuration.actuatordeserialisation.db.Db;
import com.bcp.monitoring.configuration.actuatordeserialisation.diskspace.Diskspace;
import com.bcp.monitoring.configuration.actuatordeserialisation.ping.Ping;
import lombok.Data;

public @Data class Component {
    private Db db;
    private Diskspace diskSpace;
    private Ping ping;
}
