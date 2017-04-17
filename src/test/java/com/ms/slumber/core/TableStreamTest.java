package com.ms.slumber.core;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.Table;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TableStreamTest {

    @Test
    public void loadsWholeTable() {
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        TableStream.of(Person.class, jdbcTemplate)
                .collect(Collectors.toList());

        verify(jdbcTemplate)
                .queryForList("SELECT * FROM PERSON", Person.class);
    }


    @Table(name = "PERSON")
    private class Person {
        // Nothing yet...
    }

}
