package com.company;

public class Authorization {

    Storage storage = new Storage();

    public Authorization() {
    }

    public void authorization() {
        Writen.writen(" Enter Name ");
        String loginName = Reader.readerString();
        Writen.writen(" Enter Password");
        String loginPassword = Reader.readerString();
        User user = null;
        try {
            user = storage.getUserCheExc(loginName);
            passwordCheck(user, loginPassword, loginName);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void authorization_2() {
        Writen.writen(" Enter Name ");
        String loginName = Reader.readerString();
        Writen.writen(" Enter Password");
        String loginPassword = Reader.readerString();
        User user = null;
             user = storage.getUserUncheExc(loginName);
            passwordCheck(user, loginPassword, loginName);
       }

    private void passwordCheck(User user, String loginPassword, String loginName) {
        if (loginPassword.equals(user.getPassword())) {
            Writen.writen("Hello " + loginName);
        }
        else {
            Writen.writen("Incorrect password");
        }
    }
}