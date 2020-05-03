package com.company;

import java.sql.*;

public class StorageFromTables {

    public void addUserForTables(String login, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into usersfromlogin values (default , ? , ? )");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserFromTables(String login) {
        String login2 = null;
        String password2 = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usersfromlogin u where u.login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
            login2 = resultSet.getString(2);
            password2 = resultSet.getString(3);
            }
            else {
                System.out.println("Incorrect login");
                return null;
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new User(login2, password2);
    }

    public void updateUserFromTables (int id) {
            try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("update usersfromlogin set login = ?, password = ? where id = ?");
            preparedStatement.setInt(3, id);
            if(checkIdTables(id)) {
                Writen.writen("Enter login");
                String login3 = Reader.readerString();
                preparedStatement.setString(1, login3);
                Writen.writen("Enter password");
                String password3 = Reader.readerString();
                preparedStatement.setString(2, password3);
                preparedStatement.execute();
            }
            else {
                System.out.println("Incorrect Id");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllUser() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usersfromlogin ");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("All users");
            while (resultSet.next()){
            int id = resultSet.getInt(1);
            String login2 = resultSet.getString(2);
            String password2 = resultSet.getString(3);
            System.out.println("id  " + id + " / " + "login = " + login2 +  " / " + "password = " + password2);
        }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void removeFromTables ( int id) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
                PreparedStatement preparedStatement = connection.prepareStatement("delete from usersfromlogin u where u.id = ?");
                preparedStatement.setInt(1, id);
                if (preparedStatement.execute()){
                    System.out.println("User remove");
                }
                else {
                    System.out.println("Incorrect id");
                }
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    private boolean checkIdTables(int id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usersfromlogin u where u.id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
            else {
                return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    }

