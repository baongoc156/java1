
package chuong5_bai2;

public class user {
    private String userName;
    private String passWord;

    public user() {
    }

    public user(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return  "userName=" + userName + ", passWord=" + passWord;
    }
}
