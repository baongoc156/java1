
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class QLSVController {

    //fields
    private QLSVModel model;
    private QLSVView view;
    //properties

    public QLSVModel getModel() {
        return model;
    }

    public void setModel(QLSVModel model) {
        this.model = model;
    }

    public QLSVView getView() {
        return view;
    }

    public void setView(QLSVView view) {
        this.view = view;
    }

    //ocnstructor
    public QLSVController() {
    }

    public QLSVController(QLSVModel model, QLSVView view) {
        this.model = model;
        this.view = view;

        init();

        this.view.setVisible(true);
    }
///bắt sự kiện nút chức năng
    public void init() {
        ///Nút thêm
        view.getBtn_them().addActionListener((e) -> {
            try {
                //            view.setTxtAlert("", Color.red);
                SinhVien sv = AddSV(view);
                 if (sv == null) {
                     System.out.println("bạn đã nhập sai");
//                view.setTxtAlert("Error: bạn đã nhập sai!!!", Color.red);
                return;
            }
            if (model.CheckTrungMa(model, sv.getMaSV())) {
                System.out.println("trùng mã");
//                view.setTxtAlert("Error: trùng mã!!!", Color.red);
                return;
            }
            model.Add(sv);
            ShowTable(model.getDssv());
            } catch (Exception ex) {
                Logger.getLogger(QLSVController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ///Nút Tìm
        view.getBtn_Tim().addActionListener((e) -> {
            String maCanTim = view.getTxt_Tim().getText();
            if (maCanTim.equals("")) {
                System.out.println("nhập mã môn học cần tim");
//                view.setTxtAlert("Error: nhập mã môn học cần tim!!!", Color.red);
                return;
            }

            LinkedList<SinhVien> mhs = model.Find(maCanTim);
            if (mhs.isEmpty()) {
                 System.out.println("không tìm thấy mã môn học cần tim");
//                view.setTxtAlert("Warning: không tìm thấy mã môn học cần tim!!!", Color.orange);
                return;
            }

            ShowTable(mhs);
        });
    }
///Cập nhật lại bảng sinh viên
    public void ShowTable(LinkedList<SinhVien> dssv) {
        DefaultTableModel table = (DefaultTableModel) view.getTb_SV().getModel();

        table.setColumnCount(9);
        table.setRowCount(0);

        dssv.forEach((sv) -> {
            table.addRow(new Object[]{sv.getMaSV(), sv.getHoTen(), sv.getGioiTinh(), sv.getNgaySinh(), sv.getKhoa(), sv.getLop(), sv.getEmail(), sv.getsDT(), sv.getDiaChi()});
        });

        view.getTb_SV().setModel(table);
    }
///Thêm sinh viên
    public SinhVien AddSV(QLSVView view) throws Exception {
        boolean flag = true;

        String maSV = view.getTxt_msv().getText();
        String tenSV = view.getTxt_hoTen().getText();
        String gioiTinh = view.getTxt_GT().getText();
        String ngaySinh = view.getTxt_NS().getText();
        String diaChi = view.getTxt_DC().getText();
        String email = view.getTxt_Email().getText();
        String khoa = view.getTxt_Khoa().getText();
        String lop = view.getTxt_Lop().getText();
        String sDT = view.getTxt_SDT().getText();

        if (flag && !maSV.equals("") && !tenSV.equals("")) {
            Date d = new Date();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            d = f.parse(ngaySinh);
            return new SinhVien(maSV, tenSV, gioiTinh, d, khoa, lop, email, sDT, diaChi);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        QLSVController qlsvController = new QLSVController(new QLSVModel(), new QLSVView());
    }
}
