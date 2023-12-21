package com.example.layeredarchitecture.dao.cutom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.cutom.QueryDAO;

public class QueryDAOImpl implements QueryDAO{
    @Override
    public void orderOderDetail() {
        String sql = (" SELECT * FROM Orders o RIGHT JOIN OrderDetails od ON o.oid = od.oid");

        try {
            ResultSet rst = SQLUtil.execute(sql);

            while (rst.next()){
       
            }
        System.out.println(rst);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    
}
