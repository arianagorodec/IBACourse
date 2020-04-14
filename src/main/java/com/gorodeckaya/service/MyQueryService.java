package com.gorodeckaya.service;

import java.sql.SQLException;

public interface MyQueryService {
    public String executeQuery(String query) throws SQLException;
}
