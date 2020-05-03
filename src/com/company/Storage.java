package com.company;


import java.util.ArrayList;
import java.util.List;

public class Storage {

    static List <User> list = new ArrayList<>();

    public void save (User user){
      list.add(user);
    }

    public void userlist(){
        System.out.println(list);
        }

    public User getUserCheExc(String login) throws UserNotFoundException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogin().equals(login)){
                User user = list.get(i);
                return user;
            }
        }
       throw new UserNotFoundException("User " + login + " not found");
    }

    public User getUserUncheExc(String login)  {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogin().equals(login)){
                User user = list.get(i);
                return user;
            }
        }
        throw new UserNotFoundException_2 ("User " + login + " not found");
    }
    }




