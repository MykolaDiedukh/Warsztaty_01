package main.menu;

import gra.w.zgadywanie.liczb.version.one.ReadNumber;
import gra.w.zgadywanie.liczb.version.one.Zadanie1;
import gra.w.zgadywanie.liczb.version.two.Zadanie3;
import kostka.gry.Zadanie4;
import lotto.symulator.Zadanie2;
import wyszukiwarka.najpopularniejszych.słów.Zadanie5;

import java.util.Scanner;

public class PlayGames {
    public static final String PLAY_AGAIN = "tak";
    public static void games(){

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Witam!\n" +
                    "Wybierz grę z lista: \n"+
                    "1. Gra w zgadywanie liczb\n"+
                    "2. Symulator LOTTO\n"+
                    "3. Gra w zgadywanie liczb 2\n"+
                    "4. Kostka do gry\n"+
                    "5. Wyszukiwarka najpopularniejszych słów");
            switch (new ReadNumber().repiat()){
                case 1: new Zadanie1();
                    break;
                case 2: new Zadanie2();
                    break;
                case 3: new Zadanie3();
                    break;
                case 4: new Zadanie4();
                    break;
                case 5: new Zadanie5();
                    break;
            }
            System.out.println("Zagrać znowu, Tak?");
            scanner.hasNext();
        }while (scanner.next().toLowerCase().equals(PLAY_AGAIN));
    }
    public static void main(String[] args) {
        games();
    }
}
