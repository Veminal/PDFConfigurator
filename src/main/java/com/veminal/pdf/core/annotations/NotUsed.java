package com.veminal.pdf.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotations applies to methods not used in the
 * implementation of the interface.
 *
 * @author Veminal
 * @version 1.0
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.SOURCE)
@Documented
public @interface NotUsed {
}
