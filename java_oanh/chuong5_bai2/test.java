package chuong5_bai2;

public class test {

    public static void main(String[] args) throws Exception {
        UserDAO userdao = new UserDAO();
        user user = new user("oanh1", "123");
//        userdao.addSV(user); //chèn user
//         userdao.updateSV(user); //Cập nhật mật khẩu cho user
//        String sql = "Select * from user"; //truy vấn thông tin user
//        ResultSet rs = DataBaseUtil.getData(sql); //duyệt kq trả về
//        while (rs.next()) {//di chuyển con trỏ đến mẫu tin tiếp theo            
//            String username=rs.getString(1);
//            String pass= rs.getString(2);
//            System.out.println("Username:"+username);
//            System.out.println("Pass"+pass);
//        }
        if (userdao.checkLogIn(user)) {//kiểm tra đăng nhập
            System.out.println("Dang nhap thanh cong");

        } else {
            System.out.println("Dang nhap khong thanh cong");

        }

    }

}
