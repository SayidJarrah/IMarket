package com.dkorniichuk.app.dao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActualOrderToBucketIdGenerator {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_LAST_ID = "SELECT MAX(id_order) FROM IMarket.order";

    public int getActualOrderId() {
        return jdbcTemplate.queryForObject(SQL_SELECT_LAST_ID, Integer.class) + 1;
    }

}
