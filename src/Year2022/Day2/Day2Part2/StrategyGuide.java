package Year2022.Day2.Day2Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StrategyGuide {

/*
OPPONENT :  A - STEN
            B- PAPER
            C - SAX

PLAYER  :  X - DU MÅSTE FÖRLORA
           Y - DU MÅSTE KOMMA LIKA
           Z - DU MÅSTE VINNA

           POINTS PER ROUND : 1 FÖR STEN, 2 FÖR PAPER, 3 FÖR SAX
           POINTS PER GAME : 0 FÖR FÖRLUST, 3 LIKA, 6 VINST
 */
    void readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("stratInput"));
        ArrayList<Integer> arrayList = new ArrayList<>();
        // String line = scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String a = line.substring(0, 1);
            String b = line.substring(1 + 1);
            int score = 0;
            int sum = 0;
            int points = 0;

            switch (b) {
                case "X" -> {
                    score = 0;
                    switch (a) {
                        case "A" -> points = 3;
                        case "B" -> points = 1;
                        case "C" -> points = 2;
                    }
                    sum = points + score;
                    System.out.println(sum);
                    arrayList.add(sum);
                }
                case "Y" -> {
                    score = 3;
                    points = switch (a) {
                        case "A" -> 1;
                        case "B" -> 2;
                        case "C" -> 3;
                        default -> points;
                    };
                    sum = points + score;
                    System.out.println(sum);
                    arrayList.add(sum);
                }
                case "Z" -> {
                    score = 6;
                    points = switch (a) {
                        case "A" -> 2;
                        case "B" -> 3;
                        case "C" -> 1;
                        default -> points;
                    };
                    sum = points + score;
                    System.out.println(sum);
                    arrayList.add(sum);
                }
            }

        }
        int summan=0;
        for (Integer integer : arrayList) {
            summan = summan + integer;
        }
            System.out.println(summan);
    }




    public static void main(String[] args) throws FileNotFoundException {
        StrategyGuide strategyGuide = new StrategyGuide();
        strategyGuide.readFromFile();
    }
}
