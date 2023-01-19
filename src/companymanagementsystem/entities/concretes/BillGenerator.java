package companymanagementsystem.entities.concretes;

import java.util.Scanner;

public class BillGenerator {

    public static void main(String[] args) {

        start();
    }

    public static void start() {

    }

    public static void getSelectionMenu(){

        int select = -1;

        Scanner inp = new Scanner(System.in);

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("*** Lezzet Group'a Hos Geldiniz ***");
            System.out.println("1-Restaurant");
            System.out.println("2-Cafe");
            select = inp.nextInt();
            System.out.println("----------------------------------------------------");

            switch (select){
                case 1:
                    //Restaurant Menu
                    break;
                case 2:
                    //Cafe Menu
                    break;
                default:
                    System.out.println("Hatalı giriş");
                    break;
            }

        }while (select != 0);


    }
}