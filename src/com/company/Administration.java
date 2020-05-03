package com.company;

public class Administration {

    StorageFromTables storageFromTables = new StorageFromTables();

    public void administration(){
            while (true){
                Writen.writen("Select");
                Writen.writen("1 - Find all user / 2 - Remove user / 3 - Update user / 4 - Return");
                switch (Reader.readerInt()){
                    case 1:
                        findAll();
                        break;
                    case 2:
                        removeTables();
                        break;
                    case 3:
                        updateTables();
                    case 4:
                        return;
                    case -100:
                        Writen.writen("Error");
                        break;
                }
            }

    }

    private void findAll(){
        storageFromTables.getAllUser();
    }

    private void removeTables(){
        Writen.writen(" Enter id " );
        int id = Reader.readerInt();
        storageFromTables.removeFromTables( id );
    }

    private void updateTables(){
        Writen.writen(" Enter id " );
        int id = Reader.readerInt();
        storageFromTables.updateUserFromTables(id);
    }


}
