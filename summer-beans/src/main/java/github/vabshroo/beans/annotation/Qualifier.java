package github.vabshroo.beans.annotation;

import java.lang.annotation.*;

/**
 * Create by IntelliJ IDEA
 * Qualifier annotation
 *
 * @Author chenlei
 * @DateTime 2017/10/12 9:29
 * @Description Qualifier
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";

}