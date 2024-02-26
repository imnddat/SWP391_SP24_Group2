/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Gender;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thinkpad
 */
public class GenderDAO extends DBConnection{
     public Vector<Gender> getAll() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vector<Gender> genders = new Vector<>();
        String sql = "select * from [Gender]";
        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String gender = rs.getString("gender");
                genders.add(new Gender(id, gender));
            }
            return genders;
            
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                rs.close();
                connection.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(BrandDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public Gender getBrandById(int id) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Gender genders = null;
        String sql = "select * from [Gender] where id = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                genders.setId(rs.getInt("id"));
                genders.setGender(rs.getString("gender"));
            }
            return genders;
            
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                rs.close();
                connection.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(BrandDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
