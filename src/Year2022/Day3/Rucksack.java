package Year2022.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Rucksack {
    int separateCompartments() throws FileNotFoundException {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int total=0;
        Scanner scanner = new Scanner(new File("rucksack"));
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            int sep = line.length() / 2;
            String firstC = line.substring(0, sep );
            String secondC = line.substring(sep);

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < firstC.length(); i++) {
                char a = firstC.charAt(i);
                if (secondC.contains(String.valueOf(a))) {
                    set.add(a);
                }

            }
            for (int i = 0;i<letters.length();i++){
                if (set.contains(letters.charAt(i))){
                    int sum = letters.indexOf(letters.charAt(i))+1;
                    total = total + sum;
                }
            }
        }return total;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Rucksack rucksack = new Rucksack();
        int num = rucksack.separateCompartments();
        System.out.println(num);
    }
        }