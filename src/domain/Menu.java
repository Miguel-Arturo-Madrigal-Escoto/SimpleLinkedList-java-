package domain;

import TDA.List;
import exceptions.ListException;
import java.util.Scanner;

public final class Menu {

    private String option;
    private Scanner scanner;

    private void userInterface(List myList, Song mySong) throws ListException , Throwable{
        String myStr;
        this.scanner = new Scanner(System.in);

        do {
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Mostrar elementos");
            System.out.println("4. Buscar elemento");
            System.out.println("0. Salir");
            System.out.print("-> Elige una opcion: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    mySong = new Song();

                    System.out.println("Nombre: ");
                    myStr = scanner.nextLine();
                    mySong.setName(myStr);

                    System.out.println("Autor: ");
                    myStr = scanner.nextLine();
                    mySong.setAuthor(myStr);

                    System.out.println("Interprete: ");
                    myStr = scanner.nextLine();
                    mySong.setInterprether(myStr);

                    System.out.println("Ranking");
                    myStr = scanner.nextLine();
                    mySong.setRanking(Integer.valueOf(myStr));

                    System.out.println("1. Insertar al principio");
                    System.out.println("2. Insertar despues de: ?");
                    System.out.println("3. Insertar al final");
                    myStr = scanner.nextLine();

                switch (myStr) {
                    case "1":
                        try {
                            myList.insertData(null, mySong);
                        } catch (ListException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "2":
                        Song myOtherSong = new Song();
                        System.out.println("Despues de que cancion insertar: ?");
                        myStr = scanner.nextLine();
                        myOtherSong.setName(myStr);
                        try {
                            var pos = myList.findData(myOtherSong);
                            
                            if(pos != null){
                                myList.insertData(pos, mySong);
                            }
                            
                        } catch (ListException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "3":
                        try {
                            myList.insertData(myList.getLastPos(), mySong);
                        } catch (ListException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                } 
                    break;


                case "2":
                    mySong = new Song();

                    System.out.println("Inserta el nombre de la canción a eliminar");
                    myStr = scanner.nextLine();

                    mySong.setName(myStr);
                    var pos = myList.findData(mySong);

                    try {
                        myList.deleteData(pos);
                    } catch (ListException ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;

                case "3":
                    System.out.println(myList);
                    break;

                case "4":

                    mySong = new Song();

                    System.out.println("Cancion a buscar: ");
                    myStr = scanner.nextLine();

                    mySong.setName(myStr);

                    if (myList.findData(mySong) == null) {
                        System.out.println("No hay una canción con el nombre: " + myStr);
                    } else {
                        System.out.println("Canción encontrada: ");
                        System.out.println(myList.retrieve(myList.findData(mySong)));
                    }

                    break;

                case "0":
                    myList.finalize();
                    break;

                case "5":

                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (!option.equals("0"));
    }

    public Menu(List myList, Song mySong) throws ListException, Throwable {
        userInterface(myList, mySong);
    }
}
