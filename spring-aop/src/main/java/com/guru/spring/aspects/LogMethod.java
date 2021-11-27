/**
 * @author Rajaguru Paramasivam
 * 26-Nov-2021 3:55:09 pm
 * rajagurup11@gmail.com
 */
package com.guru.spring.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogMethod {

}
