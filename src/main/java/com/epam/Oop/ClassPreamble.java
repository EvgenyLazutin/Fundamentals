package com.epam.Oop;

import java.lang.annotation.Documented;

@Documented
public @interface ClassPreamble {
    String author() default "Evgeny Lazutin";
    String date();
}
