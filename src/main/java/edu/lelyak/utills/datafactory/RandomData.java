package edu.lelyak.utills.datafactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomData {

    RandomType type();
    int min() default 1;
    int max() default 7;
    String join() default "";
}
