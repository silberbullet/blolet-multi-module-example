package me.nettee.hibenate.generator;

import me.nettee.persistence.id.Snowflake;
import me.nettee.properties.SnowflakeProperties;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SnowflakeIdGenerator implements IdentifierGenerator {
    
    private final Snowflake snowflake;
    
    public SnowflakeIdGenerator(SnowflakeProperties snowflakeProperties) {
        this.snowflake = new Snowflake(snowflakeProperties);
    }
    
    @Override
    public Long generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return snowflake.nextId();
    }
}
