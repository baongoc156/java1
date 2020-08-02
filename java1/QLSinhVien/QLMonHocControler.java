package QLSinhVien;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

public class QLMonHocControler {

    public QLMonHocModel model;
    public QLMonHocView view;

    public QLMonHocControler(QLMonHocModel model, QLMonHocView view) {
        this.model = model;
        this.view = view;

        init();

        this.view.setVisible(true);
    }

    public void init() {
        view.getBtnThem().addActionListener((e) -> {
            view.setTxtAlert("", Color.red);
            MonHoc mh = AddMonHoc(view);
            if (mh == null) {
                view.setTxtAlert("Error: bạn đã nhập sai!!!", Color.red);
                return;
            }
            if (model.CheckTrungMa(model, mh.getMaMonHoc())) {
                view.setTxtAlert("Error: trùng mã!!!", Color.red);
                return;
            }
            model.AddMonHoc(mh);
            ShowTable(model.getMonHocs());
        });

        view.getBtnFind().addActionListener((e) -> {
            String maCanTim = view.getTxtFind().getText();
            if (maCanTim.equals("")) {
                view.setTxtAlert("Error: nhập mã môn học cần tim!!!", Color.red);
                return;
            }

            LinkedList<MonHoc> mhs = model.Find(maCanTim);
            if (mhs.isEmpty()) {
                view.setTxtAlert("Warning: không tìm thấy mã môn học cần tim!!!", Color.orange);
                return;
            }

            ShowTable(mhs);
        });

        view.getBtnDelete().addActionListener((e) -> {
            int size = model.getMonHocs().size();
            String maMuonXoa = view.getTxtFind().getText();
            if (maMuonXoa.equals("")) {
                view.setTxtAlert("Error: nhập mã môn học muốn xoá!!!", Color.red);
                return;
            }

            model.setMonHocs(model.Delete(maMuonXoa));
            if (model.getMonHocs().size() == size) {
                view.setTxtAlert("Warning: không tìm thấy mã môn học muốn xoá!!!", Color.orange);
                return;
            }

            ShowTable(model.getMonHocs());
        });

//        view.getBtnSet().addActionListener((e) -> {
//            String maMuonSua = view.getTxtFind().getText();
//
//            if (maMuonSua.equals("")) {
//                view.setTxtAlert("Error: nhập mã môn học muốn sửa!!!", Color.red);
//                return;
//            }
//
//            model.setMonHocs(model.Delete(maMuonSua));
//            if (model.getMonHocs().size() == size) {
//                view.setTxtAlert("Warning: không tìm thấy mã môn học muốn xoá!!!", Color.orange);
//                return;
//            }
//
//            ShowTable(model.getMonHocs());
//            
//        });
    }

    public void ShowTable(LinkedList<MonHoc> mhs) {
        DefaultTableModel table = (DefaultTableModel) view.getDSMonHoc().getModel();

        table.setColumnCount(3);
        table.setRowCount(0);

        mhs.forEach((mh) -> {
            table.addRow(new Object[]{mh.getMaMonHoc(), mh.getTenMonHoc(), mh.getSoTinChi()});
        });

        view.getDSMonHoc().setModel(table);
    }

    public MonHoc AddMonHoc(QLMonHocView view) {
        boolean flag = true;

        String maMH = view.getTxtMaMonHoc().getText();
        String tenMH = view.getTxtTenMonHoc().getText();
        int soTinChi = 0;
        try {
            soTinChi = Integer.parseInt(view.getTxtSoTinChi().getText());
        } catch (NumberFormatException e) {
            flag = false;
        }

        if (flag && !maMH.equals("") && !tenMH.equals("")) {
            return new MonHoc(maMH, tenMH, soTinChi);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        QLMonHocControler qlMonHocControler = new QLMonHocControler(new QLMonHocModel(), new QLMonHocView());
    }

}
