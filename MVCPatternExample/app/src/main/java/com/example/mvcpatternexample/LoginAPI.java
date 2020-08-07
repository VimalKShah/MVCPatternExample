package com.example.mvcpatternexample;

public class LoginAPI {

    private UserModel userModel;
    private LoginResultInterface loginResultInterface;

    public LoginAPI(String userName, String passWord, LoginResultInterface loginResultInterface) {
        this.userModel = new UserModel(userName, passWord);
        this.loginResultInterface = loginResultInterface;
    }

    public void doLogin() {
        loginResultInterface.loginResult(userModel.checkValidity());
    }
}
