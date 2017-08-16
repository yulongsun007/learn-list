package win.yulongsun.reflect;

import java.lang.annotation.*;

/**
 * Created by sunyl21830 on 2017/8/4.
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME )
public @interface XmlField {
}
