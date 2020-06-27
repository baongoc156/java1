/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2_ch5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QLSV {

    public ArrayList<SV> getAllSV() throws SQLException {
        String sql = "select * from sv;";
        ResultSet rs = DataBaseUtil.getData(sql);
        ArrayList<SV> dssv = new ArrayList<>();

        while (rs.next()) {
            dssv.add(new SV(rs.getString("student_id"), rs.getString("name"), rs.getString("email")));
        }

        return dssv;
    }

    public SV getInStudentID(String student_id) throws SQLException {
        String sql = "select * from sv where student_id = '" + student_id + "';";
        ResultSet rs = DataBaseUtil.getData(sql);
        rs.next();
        return new SV(rs.getString(1), rs.getString(2), rs.getString(3));
    }

    public void add(SV sv) throws SQLException {
        String sql = "insert into sv values('" + sv.getStudent_id() + "','" + sv.getName() + "','" + sv.getEmail() + "')";
        DataBaseUtil.setData(sql);
    }

    public void removeInStudentID(String student_id) throws SQLException {
        String sql = "delete from sv where student_id='" + student_id + "'";
        DataBaseUtil.setData(sql);
    }

    public void updateInStudenID(SV sv, String student_id) throws SQLException {
        String sql = String.format("update sv set student_id='%s' , name = '%s', email = '%s' where student_id = '%s'", sv.getStudent_id(), sv.getName(), sv.getEmail(), student_id);
        DataBaseUtil.setData(sql);
    }
}
