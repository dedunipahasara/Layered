package com.example.layeredarchitecture.dao.cutom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    public String generateOID() throws SQLException, ClassNotFoundException;
   
}
