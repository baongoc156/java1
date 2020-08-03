/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong8_Bai5;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ChinhThucTest {
    
    public ChinhThucTest() {
    }

    

    @Test
    public void testGetLuong() {
        int e=0;
        NhanVien nv=new ChinhThuc(0, 0, "1", "2");
        int a=nv.getLuong();
        Assert.assertEquals(e, a);
    }

    @Test
    public void testGetTangCa() {
        int e=0;
        TangCa tc= new ChinhThuc(0, 0, "1", "2");
        int a=tc.getTangCa();
        Assert.assertEquals(e, a);
    }
    
}
