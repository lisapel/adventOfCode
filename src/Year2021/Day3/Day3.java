package Year2021.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

    final String file = "src/Year2021/Day3/input.txt";
    Scanner scanner;

    int part1() throws FileNotFoundException {
        scanner = new Scanner(new File(file));
        ArrayList<String>arrayList = new ArrayList<>();
        int zeroCount=0;
        int oneCount=0;
        int gammaRate=0;
        int epsilonRate=0;
        for (int i=0;i<12;i++){
            while (scanner.hasNextLine()){
                char c = scanner.nextLine().charAt(i);
                switch (c){
                    case '0'->zeroCount++;
                    case '1'->oneCount++;
                }
            }
        }


        if (zeroCount<oneCount){
            return 1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new Day3().part1());
    }
}
