package model.request;

public class Auth {
    private String userName;
    private String password;

    public Auth(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Auth(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
