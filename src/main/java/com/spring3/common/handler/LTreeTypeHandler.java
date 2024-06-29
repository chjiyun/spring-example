package com.spring3.common.handler;

import com.spring3.common.entity.LTree;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;


public class LTreeTypeHandler implements TypeHandler<LTree> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, LTree lTree, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(i, lTree.getPath(), Types.OTHER);
    }

    @Override
    public LTree getResult(ResultSet resultSet, String s) throws SQLException {
        return new LTree(resultSet.getObject(s).toString());
    }

    @Override
    public LTree getResult(ResultSet resultSet, int i) throws SQLException {
        return new LTree(resultSet.getObject(i).toString());
    }

    @Override
    public LTree getResult(CallableStatement callableStatement, int i) throws SQLException {
        return new LTree(callableStatement.getObject(i).toString());
    }
}
