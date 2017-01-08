package edu.lelyak.utills.datafactory;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
public @interface RandomData {

    RandomType type();

    int min() default 1;

    int max() default 7;

    String join() default "";
}
