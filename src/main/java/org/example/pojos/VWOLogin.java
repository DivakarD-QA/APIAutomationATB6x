package org.example.pojos;

public class VWOLogin {

    private String username ;
    private String password;
    private boolean remember;
    private String recaptchaResponseField;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    public String getRecaptchaResponseField() {
        return recaptchaResponseField;
    }

    public void setRecaptchaResponseField(String recaptchaResponseField) {
        this.recaptchaResponseField = recaptchaResponseField;
    }
}
