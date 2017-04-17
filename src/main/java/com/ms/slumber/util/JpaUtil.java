package com.ms.slumber.util;

import javax.persistence.Table;

public class JpaUtil {

    public static String findTableName(Class<?> annotatedClazz) {
        Table[] annotations = annotatedClazz.getDeclaredAnnotationsByType(Table.class);

        if(annotations.length < 1) {
            return defaultTableNameFor(annotatedClazz);
        }

        return annotations[0].name();
    }

    private static String defaultTableNameFor(Class<?> annotatedClazz) {
        return annotatedClazz.getSimpleName();
    }
}
