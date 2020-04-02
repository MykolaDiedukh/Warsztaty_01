package kostka.gry;

import java.util.Random;
import java.util.Scanner;

public class Zadanie4 {

    public Zadanie4() {
        game();
    }

    public static void game() {
        System.out.println("Aby zagrać wpisz rzuć + typ kostki");
        System.out.println("2D10+10 – 2 rzuty D10 - rodzaj kostki, do wyniku dodaj 10,");
        Scanner scanner = new Scanner(System.in);
        String diceString = scanner.nextLine();
        Random random = new Random(1 - 101);
        int[] typeOfDices = {3, 4, 6, 8, 10, 12, 20, 100};
        int sum = 0;

        String[] diceArray = diceString.split(" ");// diceArray[0] trzyma słowo rzuć
        if (diceArray[0].toLowerCase().equals("rzuć")) {
            String[] numberArray = diceArray[1].split("[+-\\-]"); // numberArray[1] trzyma liczbe którą trzeba dodać lub odjąć
            String[] typeOfArray = numberArray[0].toUpperCase().split("[D]"); // typeOfArray[0] liczba rzutów koścmi , typeOfArray[2] rodzaj kostek
            String[] symbol = diceArray[1].split("[\\w]"); //symbol[symbol.lenght-1] trzyma '+' lub '-'
            if (!typeOfArray[0].equals("")) {
                for (int i : typeOfDices) {
                    if (i == Integer.parseInt(typeOfArray[1])) {
                        if (numberArray.length == 2) {
                            int quantity = (Integer.parseInt(typeOfArray[0]));
                            do {
                                quantity--;
                                int dice = random.nextInt(Integer.parseInt(typeOfArray[1]) + 1);
                                sum = sum + dice;
                            } while (quantity != 0);
                            if (symbol[symbol.length - 1].equals("+")) {
                                sum = sum + Integer.parseInt(numberArray[1]);
                            } else {
                                sum = sum - Integer.parseInt(numberArray[1]);
                            }
                        } else {
                            int quantity = (Integer.parseInt(typeOfArray[0]));
                            do {
                                quantity--;
                                int dice = random.nextInt(Integer.parseInt(typeOfArray[1]) + 1);
                                sum = sum + dice;
                            } while (quantity != 0);
                        }
                    }
                }
            } else {
                for (int i : typeOfDices) {
                    if (i == Integer.parseInt(typeOfArray[1])) {
                        if (numberArray.length == 2) {
                            int dice = random.nextInt(Integer.parseInt(typeOfArray[1]) + 1);
                            sum = sum + dice;
                            if (symbol[symbol.length - 1].equals("+")) {
                                sum = sum + Integer.parseInt(numberArray[1]);
                            } else {
                                sum = sum - Integer.parseInt(numberArray[1]);
                            }
                        } else {
                            int dice = random.nextInt(Integer.parseInt(typeOfArray[1]) + 1);
                            sum = sum + dice;
                        }
                    }
                }
            }
            System.out.println("suma = " + sum);
        } else {
            System.out.println("Zachowaj formułę! rzuć + (ilość rzutów),(rodzaj kostki)");
        }
    }
}
