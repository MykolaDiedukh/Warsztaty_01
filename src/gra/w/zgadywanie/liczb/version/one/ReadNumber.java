package gra.w.zgadywanie.liczb.version.one;

import java.util.Scanner;

public class ReadNumber {
    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int numer = 0;
        if (scanner.hasNextInt()) {
            numer = scanner.nextInt();
        } else {
            System.out.println("To nie jest liczba.");
        }
        return numer;
    }

    public int repiat() {
        int numer = 0;
        do {
            numer = getNumber();
        } while (numer == 0);
        System.out.println(numer);
        return numer;
    }
}
