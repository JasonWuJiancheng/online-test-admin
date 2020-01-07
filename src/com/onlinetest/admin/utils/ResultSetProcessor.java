package com.onlinetest.admin.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author JasonWu
 * @create 2019-12-19-18:59
 */
@FunctionalInterface
public interface ResultSetProcessor {
    Object process(ResultSet rs) throws SQLException;
}
