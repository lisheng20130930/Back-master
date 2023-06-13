package com.qp.ots.dao;

import com.qp.ots.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    @Autowired
    private JdbcTemplate template;

    public Order queryOrder() {
        return null;
    }
}
