package com.gorodeckaya.service;

import com.gorodeckaya.entity.MyQuery;

import java.sql.SQLException;

public interface MyQueryService {
    public String executeQuery(String query) throws SQLException;
    MyQuery addMyQuery(MyQuery myQuery);
}
