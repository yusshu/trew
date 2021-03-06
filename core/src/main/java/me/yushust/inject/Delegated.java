package me.yushust.inject;

import javax.inject.Qualifier;
import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the bound type is a delegate
 * and it must be wrapped.
 * For example:
 * <pre>
 *   public interface MyHandler {
 *     // handle things...
 *   }
 *   public class MyDefaultHandler implements MyHandler {
 *     // implementations...
 *   }
 *   public class MyHandlerDecorator implements MyHandler {
 *     &#64;Inject &#64;Delegated private MyHandler delegate;
 *   }
 * </pre>
 *
 * Configured as
 * <pre>
 *   // this is the delegated handler
 *   bind(MyHandler.class).markedWith(Delegated.class).to(MyDefaultHandler.class);
 *   // this is the decorator
 *   bind(MyHandler.class).to(MyHandlerDecorator.class);
 * </pre>
 *
 * The annotation isn't used in the library, but it's
 * added here because many users of syringe (old trew)
 * added this annotation to its projects and used it
 * as specified.
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Documented
public @interface Delegated {
}
