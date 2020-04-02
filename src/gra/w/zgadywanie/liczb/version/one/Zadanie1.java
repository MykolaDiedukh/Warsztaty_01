package gra.w.zgadywanie.liczb.version.one;

import java.util.Random;

public class Zadanie1 {

    public Zadanie1() {
        game();
    }

    public static void game() {
        System.out.println("Zgadnij liczbę od 1 do 100: ");
        Random random = new Random();
        int correntNumber = random.nextInt(101);
        int numer = 0;
        do {
            numer = new ReadNumber().repiat();
            if (numer == correntNumber) {
                System.out.println(numer + " Zgadłeś!");
                break;
            } else if (numer > correntNumber) {
                System.out.println(numer + " Za dużo!");
            } else if (numer < correntNumber) {
                System.out.println(numer + " Za mało!");
            }
        } while (numer != correntNumber);
    }
}