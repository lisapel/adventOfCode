package Year2022.Day2;

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

            if (b.equals("X")) {
                score = 1;
                if (a.equals("A")) {
                    points = 3;
                } else if (a.equals("B")) {
                    points = 0;
                } else if (a.equals("C")) {
                    points = 6;
                }
                sum = points + score;
                arrayList.add(sum);

            } else if (b.equals("Y")) {
                score = 2;
                if (a.equals("A")) {
                    points = 6;
                } else if (a.equals("B")) {
                    points = 3;
                } else if (a.equals("C")) {
                    points = 0;
                }
                sum = points + score;
                arrayList.add(sum);


            } else if (b.equals("Z")) {
                score = 3;
                if (a.equals("A")) {
                    points = 0;
                } else if (a.equals("B")) {
                    points = 6;
                } else if (a.equals("C")) {
                    points = 3;
                }
                sum = points + score;


                arrayList.add(sum);
            }

        }
        int summan=0;
        for (int i = 0;i<arrayList.size();i++){
            summan=summan+arrayList.get(i);
        }
            System.out.println(summan);
    }




    public static void main(String[] args) throws FileNotFoundException {
        StrategyGuide strategyGuide = new StrategyGuide();
        strategyGuide.readFromFile();
    }
}
