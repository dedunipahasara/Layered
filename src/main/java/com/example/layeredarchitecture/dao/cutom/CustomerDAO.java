package com.example.layeredarchitecture.dao.cutom;


import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;


public interface CustomerDAO extends CrudDAO<CustomerDTO> {
     
     
     String generateNewId() throws SQLException, ClassNotFoundException;
}
