package zad1;

import java.util.Random;
import java.util.Scanner;

public class Main {



    public static int getNumber(){
        Scanner scanner = new Scanner(System.in);
        int numer = 0;
        if(scanner.hasNextInt()){
            numer = scanner.nextInt();
        } else {
            System.out.println("To nie jest liczba.");
        }
        return numer;
    }

    public static void game (){
        System.out.println("Zgadnij liczbę: ");
        Random random = new Random();
        int correntNumber = random.nextInt(101);
        int numer = 0;
        do {
            numer = repiat();
            if (numer== correntNumber){
                System.out.println(numer + " Zgadłeś!");
                break;
            } else if (numer < correntNumber){
                System.out.println(numer + " Za dużo!");
            } else  if (numer > correntNumber){
                System.out.println(numer + " Za mało!");
            }
        } while (numer == correntNumber);
    }

    public static int repiat() {
        int numer = 0;
        do {
            numer = getNumber();
        } while (numer ==0 );
        System.out.println(numer);
        return numer;
    }

    public static void main(String[] args) {
        game();
    }

}