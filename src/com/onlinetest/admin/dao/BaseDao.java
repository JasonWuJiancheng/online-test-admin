package com.onlinetest.admin.dao;

import com.onlinetest.admin.utils.JDBCUtil;
import com.onlinetest.admin.utils.ResultSetProcessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author JasonWu
 * @create 2019-12-19-18:45
 */
public class BaseDao {

    /**
     * 增、删、改操作
     * @param sql
     * @param params
     * @return 执行结果
     */
    public int executeUpdate(String sql, Object... params) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.getConnection();
            if (conn != null && !conn.isClosed()) {
                pstmt = conn.prepareStatement(sql);
                if(params != null) {
                    for (int i = 0; i < params.length; i++) {
                        pstmt.setObject(i + 1, params[i]);
                    }
                }
                result = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(null,pstmt,conn);
        }
        return result;
    }

    /**
     * 查询操作
     * @param sql
     * @param params
     * @param processor
     * @return 执行结果
     */
    public Object executeQuery(ResultSetProcessor processor, String sql,
                               Object... params) {
        Object result = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            if (conn != null && conn.isClosed() == false) {
                pstmt = conn.prepareStatement(sql);
                if(params != null) {
                    for (int i = 0; i < params.length; i++) {
                        pstmt.setObject(i + 1, params[i]);
                    }
                }
                rs = pstmt.executeQuery();
                result = processor.process(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(rs,pstmt,conn);
        }
        return result;
    }
}
