package year2022.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StrategyGuide {

/*
OPPONENT :  A - STEN
            B- PAPER
            C - SAX

PLAYER  :  X - STEN
           Y - PAPER
           Z - SAX

           POINTS PER ROUND : 1 FÖR STEN, 2 FÖR PAPER, 3 FÖR SAX
           POINTS PER GAME : 0 FÖR FÖRLUST, 3 LIKA, 6 VINST
 */
    void readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("stratInput"));
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String a = line.substring(0, 1);
            String b = line.substring(1 + 1);
            System.out.println(a + "och " + b);
            int score = 0;
            int sum = 0;
            int points = 0;

            switch (b) {
                case "X" -> {
                    score = 1;
                    switch (a) {
                        case "A" -> points = 3;
                        case "B" -> {
                        }
                        case "C" -> points = 6;
                    }
                    sum = points + score;
                    arrayList.add(sum);
                }
                case "Y" -> {
                    score = 2;
                    points = switch (a) {
                        case "A" -> 6;
                        case "B" -> 3;
                        case "C" -> 0;
                        default -> points;
                    };
                    sum = points + score;
                    arrayList.add(sum);
                }
                case "Z" -> {
                    score = 3;
                    points = switch (a) {
                        case "A" -> 0;
                        case "B" -> 6;
                        case "C" -> 3;
                        default -> points;
                    };
                    sum = points + score;
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
