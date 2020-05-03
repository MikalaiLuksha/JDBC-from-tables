package com.company;

public class AuthorizationTables {

    public void AuthTables() {
        StorageFromTables storageFromTables = new StorageFromTables();
        Writen.writen(" Enter Name ");
        String loginName = Reader.readerString();
        User user = storageFromTables.getUserFromTables(loginName);
        if (user != null){
        Writen.writen(" Enter Password");
        String loginPassword = Reader.readerString();
        if (loginPassword.equals(user.getPassword())) {
            Writen.writen("Hello " + loginName);
        } else {
            Writen.writen("Incorrect password");
        }
        }
    }
}

