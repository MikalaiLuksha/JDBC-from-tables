package com.company;

public class Registration {

//    Storage storage = new Storage();
    StorageFromTables storageFromTables = new StorageFromTables();

    public void registration(){
        Writen.writen(" Enter Name " );
        String loginName = Reader.readerString();
        Writen.writen(" Enter Password");
        String loginPassword = Reader.readerString();
//        User user = new User(loginName, loginPassword);
//        storage.save(new User(loginName, loginPassword));
        storageFromTables.addUserForTables(loginName, loginPassword);
    }
}

