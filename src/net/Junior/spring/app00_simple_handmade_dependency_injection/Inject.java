package net.Junior.spring.app00_simple_handmade_dependency_injection;

import java.lang.annotation.*;

/**
 * Created by root on 25.04.2015.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
    public String value();
}
