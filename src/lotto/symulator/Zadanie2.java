package lotto.symulator;

import gra.w.zgadywanie.liczb.version.one.ReadNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zadanie2 {

    public Zadanie2(){
        game();
    }

    public static void game() {
        List<Integer> userNumbers = userNumbers();
        List<Integer> lottoNumbers = lottoNumbers();
        int i = 0;
        for (int userNmber : userNumbers){
            for (int lottonumber: lottoNumbers){
                if(userNmber == lottonumber){
                    i++;
                    System.out.println("Zgadleś " + userNmber);
                }
            }
        }
        System.out.println("Zgadleś " + i + " liczb");
    }

    private static List<Integer> lottoNumbers() {
        List<Integer> list = new ArrayList<>();

        Random random = new Random();
        do {
            int lottoNumbers = random.nextInt(50);
            if (!list.contains(lottoNumbers)) {
                list.add(lottoNumbers);
            }
        } while (list.size() != 6);
        return list;
    }

    private static List<Integer> userNumbers() {
        List<Integer> list = new ArrayList();
        do {
            System.out.println("Wpisz liczbe w zakresie od 1 do 49: ");
            int repiat = new ReadNumber().repiat();
            if (repiat >= 1 && repiat <= 49) {
                if (!list.contains(repiat)) {
                    list.add(repiat);
                } else {
                    System.out.println("Taka liczba już wpisana");
                }
            } else {
                System.out.println("Liczba musi być w zakresie od 1 do 49");
            }

        } while (list.size() != 6);
        return list;
    }
}
