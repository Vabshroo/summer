package github.vabshroo.beans.annotation;

import java.lang.annotation.*;

/**
 * Create by IntelliJ IDEA
 * Autowired annotation
 *
 * @Author chenlei
 * @DateTime 2017/10/12 9:22
 * @Description AutoWired
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    boolean required() default true;

}