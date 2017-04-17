package com.ms.slumber.util;


import org.junit.Test;

import javax.persistence.Table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JpaUtilTest {

    @Test
    public void tableAnnotationForName() {
        assertThat(JpaUtil.findTableName(TableOne.class),
                is("SomeValue"));


    }

    @Test
    public void clazzAnnotationFallback() {
        assertThat(JpaUtil.findTableName(TableTwo.class),
                is("TableTwo"));


    }

    @Table(name = "SomeValue")
    class TableOne {

    }

    class TableTwo {}

}