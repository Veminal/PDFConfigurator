package net.veminal.pdf.core.annotations;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A binding annotation for extracting by number.
 *
 * @author Veminal
 * @version 1.0
 */
@Target({ElementType.FIELD, ElementType.PARAMETER,
        ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
public @interface Number {
}
