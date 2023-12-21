package com.example.layeredarchitecture.dao.cutom;


import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO>{
    
    public String genarateId() throws SQLException, ClassNotFoundException;
    
}
