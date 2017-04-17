package com.ms.slumber.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.persistence.Table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Tag("fast")
class JpaUtilTest {

    @Test
    @DisplayName("Uses JPA 'Table' annotation for Table Name")
    public void tableAnnotationForName() {
        assertThat(JpaUtil.findTableName(TableOne.class),
                is("SomeValue"));


    }

    @Test
    @DisplayName("Uses Class Name if not annotated by 'Table")
    public void clazzAnnotationFallback() {
        assertThat(JpaUtil.findTableName(TableTwo.class),
                is("TableTwo"));


    }

    @Table(name = "SomeValue")
    class TableOne {

    }

    class TableTwo {}

}