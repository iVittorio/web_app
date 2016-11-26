package ru.innopolis.uni;

import ru.innopolis.uni.dao.LectionDAO;

/**
 * Created by i.viktor on 25/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(LectionDAO.getLectionById(1));
    }
}
