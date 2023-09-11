package Year2022.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartTwo{


    public PartTwo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Day4/pairInput"));
        int counter=0;
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String sub1 = line.substring(0, line.indexOf(","));
            String sub2 = line.substring(line.indexOf(",") + 1);

            String firstnum = sub1.substring(0, sub1.indexOf("-"));
            String secondNum = sub1.substring(sub1.indexOf("-") + 1);
            String thirdNum = sub2.substring(0, sub2.indexOf("-"));
            String fourthNum = sub2.substring(sub2.indexOf("-") + 1);

            int one = Integer.parseInt(firstnum);
            int two = Integer.parseInt(secondNum);
            int three = Integer.parseInt(thirdNum);
            int four = Integer.parseInt(fourthNum);


            if (one <= three && two >= four ) {  //|| three <= one && four >= two) {


            }

        }
        System.out.println(counter);
    }
    public static void main(String[] args) throws FileNotFoundException {
        new PartTwo();
    }}


