package tech.viacomcbs.intothespring.conditionals;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnAClassCondition.class)
public @interface SampleConditional {

}
