package com.onlinetest.admin.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author JasonWu
 * @create 2019-12-19-18:42
 */
public class JDBCUtil {
    private static DataSource ds = new ComboPooledDataSource();

    /**
     * 获取连接池
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭连接
     * @param resultSet
     * @param pstmt
     * @param connection
     */
    public static void closeAll(ResultSet resultSet, PreparedStatement pstmt, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeAll(PreparedStatement pstmt,Connection conn) {
        closeAll(null, pstmt, conn);
    }
}
