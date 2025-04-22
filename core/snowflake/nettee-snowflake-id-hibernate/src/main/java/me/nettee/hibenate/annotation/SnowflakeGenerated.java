package me.nettee.hibenate.annotation;

import me.nettee.hibenate.generator.SnowflakeIdGenerator;
import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@IdGeneratorType(SnowflakeIdGenerator.class)
public @interface SnowflakeGenerated {
}
