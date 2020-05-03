package com.company;

public class Application {

    private boolean flack = true;

    Registration registration = new Registration();
//    Authorization authorization = new Authorization();
    AuthorizationTables authorizationTables = new AuthorizationTables();
    Storage storage = new Storage();
    Administration administration = new Administration();

    public void star(){
        while (flack){
            menuEnter();
            switch (Reader.readerInt()){
                case 0:
                    administration.administration();
                    break;
                case 1:
                    registration.registration();
                    break;
                case 2:
                    authorizationTables.AuthTables();
//                    authorization.authorization();
//                    authorization.authorization_2();
                    break;
                case 3:
                    storage.userlist();
                    break;
                case 4:
                    flack = false;
                    Writen.writen("Goodbye");
                    return;
                case -100:
                    Writen.writen("Error");
                    break;
            }
        }
    }
    private void menuEnter(){
        Writen.writen("Select");
        Writen.writen("0 - Administration / 1 - Registration / 2 - Authorise / 3 - Users / 4 - Exit ");
    }

}
