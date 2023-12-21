package com.example.layeredarchitecture.dao.cutom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.cutom.ItemDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public  ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        
       
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> getAllItem=new ArrayList<>();
        while (rst.next()) {
           ItemDTO itemDTO=new ItemDTO(rst.getString(1),rst.getString(2),rst.getBigDecimal(3),rst.getInt(4));
           getAllItem.add(itemDTO);
        }
        return getAllItem;
    }
    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
       

    }
    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
       
    }
    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
       
    }
    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {

        ResultSet rst= SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
        return rst.next();
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
       
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
    @Override
    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
        
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",code);
        rst.next();
        return new ItemDTO(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
   

}