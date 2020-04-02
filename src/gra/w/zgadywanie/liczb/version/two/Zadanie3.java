package gra.w.zgadywanie.liczb.version.two;

import gra.w.zgadywanie.liczb.version.one.ReadNumber;

import java.util.Scanner;

public class Zadanie3 {

    public Zadanie3() {
        game();
    }

    public static void calculation(int number) {
        int max = 1000;
        int min = 0;
        int guess = (((max - min) / 2) + min);
        int i = 0;
        int stop = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            i++;
            System.out.println("Wybrałeś " + guess + " proba " + i);
            System.out.println("wpisz 'M' jeśli ża dużo\n" +
                    "'L' jeśli ża mało\n" +
                    "'W' jeśli trafiłem");
            scanner.hasNext();
            switch (scanner.next()) {
                case "M":
                    max = guess;
                    guess = (((max - min) / 2) + min);
                    break;
                case "L":
                    min = guess;
                    guess = (((max - min) / 2) + min);
                    break;
                case "W":
                    System.out.println("Wygrałeś!");
                    stop = 1;
                    break;
            }
        } while (i != 10 && stop != 1);
    }

    public static void game() {
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbach");
        calculation(new ReadNumber().repiat());
    }
}
