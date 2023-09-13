package year2022.day1.Day1Part2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ElfCalories {
    void readAndPrintOnFile(){
        String file ="src/Day2/Calories.txt";
        year2022.day1.ElfCalories.readFile(file);

    }
    int biggestValue() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("res.txt"));
        int big = scanner.nextInt();
        while (scanner.hasNextInt()){
            int num = scanner.nextInt();
            if (num>big){
                big=num;
            }

        }
        return big;

    }
    void biggestThreeValues() throws FileNotFoundException {
        ArrayList<Integer>arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(new File("res.txt"));
        int big = scanner.nextInt();
        while (scanner.hasNextInt()){
             big = scanner.nextInt();
            arrayList.add(big);

        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        int res=0;

        for (int i=0; i<3;i++){
           int b =  arrayList.get(i);
           res = res+b;

        }
        System.out.println(res);
    }




    public static void main(String[] args) throws IOException {
        ElfCalories elfCalories = new ElfCalories();
        elfCalories.readAndPrintOnFile();
         elfCalories.biggestThreeValues();
    }}


