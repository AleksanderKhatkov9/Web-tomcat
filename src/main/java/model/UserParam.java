package model;

public class UserParam {

    private String userParamName;
    private String userParamPassword;

    public UserParam(String userParamName, String userParamPassword) {
        this.userParamName = userParamName;
        this.userParamPassword = userParamPassword;
    }

    public String getUserParamName() {
        return userParamName;
    }

    public void setUserParamName(String userParamName) {
        this.userParamName = userParamName;
    }

    public String getUserParamPassword() {
        return userParamPassword;
    }

    public void setUserParamPassword(String userParamPassword) {
        this.userParamPassword = userParamPassword;
    }
}
