package ru.innopolis.uni;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        String firstName, lastName, email, username, password;
        firstName = "firstName";
        lastName = "lastName";
        email = "email";
        username = "username";
        password = "password";


        UserBean bean = new UserBean(username, password, firstName, lastName, email);

        boolean register = UserDAO.register(bean);

        System.out.println(register);

        UserBean bean1 = new UserBean(username, password, firstName, lastName, email);


        boolean register1 = UserDAO.register(bean1);

        System.out.println(register1);

    }
}
