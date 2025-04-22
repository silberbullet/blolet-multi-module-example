package me.nettee.properties;

import me.nettee.properties.allowed.CorsAllowedProperties;
import me.nettee.properties.exposed.CorsExposedProperties;

public record MappedCorsProperties(
        String path,
        CorsAllowedProperties allowed,
        CorsExposedProperties exposed,
        Long maxAge
) {
    public MappedCorsProperties {
        if (maxAge == null) {
            maxAge = 3600L;
        }
    }
}
