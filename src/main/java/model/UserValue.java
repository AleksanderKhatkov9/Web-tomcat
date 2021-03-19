package model;

public class UserValue {
    private String paramSqlName;
    private String paramSqlPassword;

    public UserValue() {
    }

    public UserValue(String paramSqlName, String paramSqlPassword) {
        this.paramSqlName = paramSqlName;
        this.paramSqlPassword = paramSqlPassword;
    }

    public String getParamSqlName() {
        return paramSqlName;
    }

    public void setParamSqlName(String paramSqlName) {
        this.paramSqlName = paramSqlName;
    }

    public String getParamSqlPassword() {
        return paramSqlPassword;
    }

    public void setParamSqlPassword(String paramSqlPassword) {
        this.paramSqlPassword = paramSqlPassword;
    }
}
