package main;

import TDA.*;
import domain.*;
import exceptions.ListException;

public class Main {

    public static void main(String[] args) throws ListException, Throwable{
        List<Song> myList = new List();
        Song mySong = new Song();
        Menu myMenu = new Menu(myList, mySong);

    }

}
