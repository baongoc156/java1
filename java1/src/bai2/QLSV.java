/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QLSV {
    public ArrayList<SV> getAllSV() throws SQLException{
        String sql = "select * from sv;";
        ResultSet rs = DataBaseUtil.getData(sql);
        ArrayList<SV> dssv = new ArrayList<>();
        
        while (rs.next()) {            
            dssv.add(new SV(rs.getString("student_id"), rs.getString("name"), rs.getString("email")));
        }
        
        return dssv;
    }
}
